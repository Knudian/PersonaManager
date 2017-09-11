package PersonaManager.DAO.Interface;

import PersonaManager.Model.CaracteristicModified;

public interface ICaracteristicModifiedDAO {

    public CaracteristicModified create(CaracteristicModified caracteristicModified);

    public CaracteristicModified getById(long id);

    public void delete(CaracteristicModified caracteristicModified);

    public CaracteristicModified update(CaracteristicModified caracteristicModified);

}
