package PersonaManager.Service.Interface;

import PersonaManager.Model.CaracteristicModified;

public interface ICaracteristicModifiedService {

    public Long create(String entityAsString);

    public String getById(long id);

    public Boolean update(String entityAsString);

    public Boolean delete(String entityAsString);

    public CaracteristicModified getEntity(long id);

}
