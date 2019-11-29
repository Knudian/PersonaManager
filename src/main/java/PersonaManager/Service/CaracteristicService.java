package PersonaManager.Service;

import PersonaManager.DAO.Interface.ICaracteristicDAO;
import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.GameSystem;
import PersonaManager.Model.Portage;
import PersonaManager.Service.Interface.ICaracteristicService;
import PersonaManager.Service.Interface.IGameSystemService;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

@Service
public class CaracteristicService implements ICaracteristicService {

    private final ICaracteristicDAO caracteristicDAO;
    private final ICaracteristicFactory caracteristicFactory;
    private final IPortageService portageService;
    private final IGameSystemService gameSystemService;

    @Autowired
    public CaracteristicService(ICaracteristicDAO caracteristicDAO, ICaracteristicFactory caracteristicFactory, IPortageService portageService, IGameSystemService gameSystemService){
        this.caracteristicDAO = caracteristicDAO;
        this.caracteristicFactory = caracteristicFactory;
        this.portageService = portageService;
        this.gameSystemService = gameSystemService;
    }

    @Override
    public Long create(String entityAsString) {
        Caracteristic caracteristic = caracteristicFactory.fromJson(entityAsString);
        caracteristic = caracteristicDAO.create(caracteristic);

        GameSystem gameSystem = gameSystemService.getEntity(caracteristic.getGameSystem().getId(), true);

        for(Portage p : gameSystem.getPortageList()){
            portageService.createMissingCaracteristicModified(p);
        }

        return caracteristic.getId();
    }

    @Override
    public JsonValue getById(long id, boolean complete) {
        return caracteristicFactory.toJson(this.getEntity(id), complete);
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
        Caracteristic original = this.getEntity(id);
        Caracteristic updated  = caracteristicFactory.fromJson(entityAsString);

        if( !updated.equals(original) ){
            if( updated.getType() != null){
                original.setType(updated.getType());
            }
            if( updated.getDefaultLabel() != null){
                original.setDefaultLabel(updated.getDefaultLabel());
            }
            if( updated.getMaximum() != null){
                original.setMaximum(updated.getMaximum());
            }
            if( updated.getMinimum() != null ){
                original.setMaximum(updated.getMaximum());
            }

            original = caracteristicDAO.update(original);
        }
        return caracteristicFactory.toJson(original, false);
    }

    @Override
    public Boolean delete(long id) {
        try {
            caracteristicDAO.delete(this.getEntity(id));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Caracteristic getEntity(long id) {
        return caracteristicDAO.getById(id);
    }

    @Override
    public JsonArray listToJson(List<Caracteristic> list) {
        return caracteristicFactory.listToJson(list);
    }

    @Override
    public JsonValue patch(long id, String patchingValues) {
        Caracteristic caracteristic = caracteristicFactory.patch(this.getEntity(id), patchingValues);
        return caracteristicFactory.toJson(caracteristicDAO.update(caracteristic), false);
    }
}
