package PersonaManager.Service;

import PersonaManager.DAO.Interface.ICaracteristicModifiedDAO;
import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Service.Interface.ICaracteristicModifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicModifiedService implements ICaracteristicModifiedService {

    public CaracteristicModifiedService(){}

    @Autowired
    private ICaracteristicModifiedDAO caracteristicModifiedDAO;
    @Autowired
    private ICaracteristicModifiedFactory caracteristicModifiedFactory;

    @Override
    public Long create(String entityAsString) {
        CaracteristicModified caracteristicModified = caracteristicModifiedDAO.create(caracteristicModifiedFactory.fromJson(entityAsString));
        return caracteristicModified.getId();
    }

    @Override
    public String getById(long id) {
        return caracteristicModifiedFactory.toJson(this.getEntity(id));
    }

    @Override
    public Boolean update(String entityAsString) {
        try {
            caracteristicModifiedDAO.update(caracteristicModifiedFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            caracteristicModifiedDAO.delete(caracteristicModifiedFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public CaracteristicModified getEntity(long id) {
        return caracteristicModifiedDAO.getById(id);
    }
}
