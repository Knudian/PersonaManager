package PersonaManager.Service.Interface;

import PersonaManager.Model.Universe;

import java.util.List;

public interface IUniverseService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public Boolean update(String entityAsString);

    public Boolean delete(String entityAsString);

    public String getAll(boolean complete);

    public Universe getEntity(long id, boolean complete);
}
