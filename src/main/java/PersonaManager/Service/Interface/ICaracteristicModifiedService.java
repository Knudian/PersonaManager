package PersonaManager.Service.Interface;

import PersonaManager.Model.CaracteristicModified;

public interface ICaracteristicModifiedService {

    public Long create(String entityAsString);

    public String getById(long id);

    public String update(String entityAsString, long id);

    public Boolean delete(long id);

    public CaracteristicModified getEntity(long id);

}
