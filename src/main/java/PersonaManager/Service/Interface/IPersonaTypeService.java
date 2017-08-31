package PersonaManager.Service.Interface;

import PersonaManager.Model.PersonaType;

public interface IPersonaTypeService {

    public Long create(String entityAsString);

    public String getById(long id);

    public Boolean update(String entityAsString);

    public Boolean delete(String entityAsString);
}
