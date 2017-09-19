package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPortageDAO;
import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.*;
import PersonaManager.Service.Interface.ICaracteristicModifiedService;
import PersonaManager.Service.Interface.IGameSystemService;
import PersonaManager.Service.Interface.IPersonaService;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.validation.ConstraintDeclarationException;
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
    @Autowired
    private IPersonaService personaService;

    @Override
    public Long create(String entityAsString) {
        Portage portage = portageFactory.fromJson(entityAsString);
        portage = portageDAO.create(portage);
        portage = this.init(portage);
        return portage.getId();
    }

    @Override
    public JsonValue getById(long id, boolean complete) {
        return portageFactory.toJson(this.getEntity(id, complete), complete);
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
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
    public JsonValue getAll(boolean complete) {
        List<Portage> portageList = portageDAO.getAll(complete);
        return portageFactory.listToJson(portageList, complete);
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

            caracteristicModifiedList.add(caracteristicModifiedService.createStandard(portage, caracteristic));
        }

        portage.setCaracteristicList(caracteristicModifiedList);

        return portageDAO.update(portage);
    }

    @Override
    public JsonArray listToJson(List<Portage> list, boolean complete) {
        return portageFactory.listToJson(list, complete);
    }

    @Override
    public void createMissingCaracteristicModified(Portage portage) {

        portage = this.getEntity(portage.getId(), true);

        GameSystem gameSystem = gameSystemService.getEntity(portage.getId(), true);

        List<Caracteristic> listC = gameSystem.getCaracteristicList();
        List<CaracteristicModified> listCM = portage.getCaracteristicList();

        for (Caracteristic c : listC) {
            try {
                listCM.add(caracteristicModifiedService.createStandard(portage, c));
            } catch (Exception e) {
                // do nothing !
            }
        }

        portage.setCaracteristicList(listCM);
        portage = portageDAO.update(portage);
        for(Persona p : portage.getPersonaList()){
            try {
                personaService.createMissingPersonaCaracteristic(p, listCM);
            } catch (Exception e){
                // do nothing !
            }
        }

    }
}
