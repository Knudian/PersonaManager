package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPortageDAO;
import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.GameSystem;
import PersonaManager.Model.Portage;
import PersonaManager.Service.Interface.ICaracteristicModifiedService;
import PersonaManager.Service.Interface.IGameSystemService;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortageService implements IPortageService {

    public PortageService() {}

    @Autowired
    private IPortageDAO portageDAO;

    @Autowired
    private IPortageFactory portageFactory;
    @Autowired
    private IGameSystemService gameSystemService;
    @Autowired
    private ICaracteristicModifiedService caracteristicModifiedService;
    @Autowired
    private ICaracteristicModifiedFactory caracteristicModifiedFactory;

    @Override
    public Long create(String entityAsString) {
        Portage portage = portageFactory.fromJson(entityAsString);
        portage = portageDAO.create(portage);
        portage = this.init(portage);
        return portage.getId();
    }

    @Override
    public String getById(long id, boolean complete) {
        return portageFactory.toJson(this.getEntity(id, complete), complete);
    }

    @Override
    public String update(String entityAsString, long id) {
        Portage original = this.getEntity(id, false);
        Portage updated  = portageFactory.fromJson(entityAsString);

        if( updated.getGameSystem() != null){
            original.setGameSystem(updated.getGameSystem());
        }
        if( updated.getUniverse() != null){
            original.setUniverse(updated.getUniverse());
        }

        original = portageDAO.update(original);

        return portageFactory.toJson(original, false);
    }

    @Override
    public Boolean delete(long id) {
        try {
            portageDAO.delete(this.getEntity(id, false));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public String getAll(boolean complete) {
        List<Portage> portageList = portageDAO.getAll(complete);
        return portageFactory.allToJson(portageList, complete);
    }

    @Override
    public Portage getEntity(long id, boolean complete) {
        return portageDAO.getById(id, complete);
    }


    @Override
    public Portage init(Portage portage) {
        GameSystem gameSystem = gameSystemService.getEntity(portage.getGameSystem().getId(), true);

        List<CaracteristicModified> caracteristicModifiedList = new ArrayList<>();

        for(Caracteristic caracteristic : gameSystem.getCaracteristicList()){

            CaracteristicModified caracteristicModified = new CaracteristicModified();

            caracteristicModified.setPortage(portage);
            caracteristicModified.setCaracteristic(caracteristic);

            long id = caracteristicModifiedService.create(caracteristicModifiedFactory.toJson(caracteristicModified));
            caracteristicModifiedList.add(caracteristicModifiedService.getEntity(id));
        }

        portage.setCaracteristicList(caracteristicModifiedList);

        return portageDAO.update(portage);
    }
}
