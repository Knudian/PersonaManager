package PersonaManager.Service;

import PersonaManager.DAO.Interface.ICaracteristicDAO;
import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.EnumCaracType;
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
    public String update(String entityAsString, long id) {
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
        return caracteristicFactory.toJson(original);
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
}
