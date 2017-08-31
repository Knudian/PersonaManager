package PersonaManager.Service.Interface;

import PersonaManager.Model.Portage;

import java.util.List;

public interface IPortageService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public Boolean update(String entityAsString);

    public Boolean delete(String entityAsString);

    public String getAll(boolean complete);

    public Portage getEntity(long id, boolean complete);
}
