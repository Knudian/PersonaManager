package PersonaManager.Service;

import PersonaManager.DAO.Interface.ICaracteristicDAO;
import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Service.Interface.ICaracteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicService implements ICaracteristicService {

    @Autowired
    private ICaracteristicDAO caracteristicDAO;

    @Autowired
    private ICaracteristicFactory caracteristicFactory;

    public CaracteristicService(){}

    @Override
    public Long create(String entityAsString) {
        Caracteristic caracteristic = caracteristicFactory.fromJson(entityAsString);
        caracteristic = caracteristicDAO.create(caracteristic);
        return caracteristic.getId();
    }

    @Override
    public String getById(long id) {
        return caracteristicFactory.toJson(this.getEntity(id));
    }

    @Override
    public Boolean update(String entityAsString) {
        try {
            caracteristicDAO.update(caracteristicFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            caracteristicDAO.delete(caracteristicFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Caracteristic getEntity(long id) {
        return caracteristicDAO.getById(id);
    }
}
