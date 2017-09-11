package PersonaManager.Service.Interface;

import PersonaManager.Model.Universe;

import java.util.List;

public interface IUniverseService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public String update(String entityAsString, long id);

    public Boolean delete(long id);

    public String getAll(boolean complete);

    public Universe getEntity(long id, boolean complete);
}
