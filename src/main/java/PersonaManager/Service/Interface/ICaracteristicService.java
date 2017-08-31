package PersonaManager.Service.Interface;

import PersonaManager.Model.Caracteristic;

public interface ICaracteristicService {

    public Long create(String entityAsString);

    public String getById(long id);

    public Boolean update(String entityAsString);

    public Boolean delete(String entityAsString);

    public Caracteristic getEntity(long id);

}
