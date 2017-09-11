package PersonaManager.Service.Interface;

import PersonaManager.Model.PersonaType;

public interface IPersonaTypeService {

    public Long create(String entityAsString);

    public String getById(long id);

    public String update(String entityAsString, long id);

    public Boolean delete(long id);

    public PersonaType getEntity(long id);
}
