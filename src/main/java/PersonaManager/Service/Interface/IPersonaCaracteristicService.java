package PersonaManager.Service.Interface;

import PersonaManager.Model.PersonaCaracteristic;

public interface IPersonaCaracteristicService {

    public Long create(String entityAsString);

    public String getById(long id);

    public String update(String entityAsString, long id);

    public Boolean delete(String entityAsString);

    public PersonaCaracteristic getEntity(long id);
}
