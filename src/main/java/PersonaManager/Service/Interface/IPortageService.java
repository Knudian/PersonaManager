package PersonaManager.Service.Interface;

import PersonaManager.Model.Portage;

import java.util.List;

public interface IPortageService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public String update(String entityAsString, long id);

    public Boolean delete(long id);

    public String getAll(boolean complete);

    public Portage getEntity(long id, boolean complete);

    public Portage init(Portage portage);
}
