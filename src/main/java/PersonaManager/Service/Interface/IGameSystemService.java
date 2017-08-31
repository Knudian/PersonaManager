package PersonaManager.Service.Interface;

import PersonaManager.Model.GameSystem;

import java.util.List;

public interface IGameSystemService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public Boolean update(String entityAsString);

    public Boolean delete(String entityAsString);

    public String getAll();

    public GameSystem getEntity(long id, boolean complete);
}
