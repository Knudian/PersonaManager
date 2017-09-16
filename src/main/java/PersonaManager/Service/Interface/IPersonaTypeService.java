package PersonaManager.Service.Interface;

import PersonaManager.Model.PersonaType;

import javax.json.JsonValue;

public interface IPersonaTypeService {

    public Long create(String entityAsString);

    public JsonValue getById(long id);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public PersonaType getEntity(long id);
}
