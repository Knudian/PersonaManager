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
    public String update(String entityAsString, long id) {
        CaracteristicModified original = this.getEntity(id);
        CaracteristicModified updated  = caracteristicModifiedFactory.fromJson(entityAsString);

        if( !updated.equals(original) ){
            original.setPortage(updated.getPortage());
            original.setCaracteristic(updated.getCaracteristic());
            original.setLabel(updated.getLabel());

            original = caracteristicModifiedDAO.update(original);
        }

        return caracteristicModifiedFactory.toJson(original);
    }

    @Override
    public Boolean delete(long id) {
        try {
            caracteristicModifiedDAO.delete(this.getEntity(id));
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
