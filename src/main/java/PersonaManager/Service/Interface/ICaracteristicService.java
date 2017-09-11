package PersonaManager.Service.Interface;

import PersonaManager.Model.Caracteristic;

public interface ICaracteristicService {

    public Long create(String entityAsString);

    public String getById(long id);

    public String update(String entityAsString, long id);

    public Boolean delete(long id);

    public Caracteristic getEntity(long id);

}
