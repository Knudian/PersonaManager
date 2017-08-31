package PersonaManager.Service.Interface;

import PersonaManager.Model.Human;

import java.util.List;

public interface IHumanService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public Boolean update(String entityAsString);

    public Boolean delete(String entityAsString);

    public String getAll();

    public Human getEntity(long id, boolean complete);
}
