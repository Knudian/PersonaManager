package PersonaManager.Service.Interface;

import PersonaManager.Model.GameSystem;

import java.util.List;

public interface IGameSystemService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public String update(String entityAsString, long id);

    public Boolean delete(long id);

    public String getAll();

    public GameSystem getEntity(long id, boolean complete);
}
