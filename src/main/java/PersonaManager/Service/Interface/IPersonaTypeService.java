package PersonaManager.Service.Interface;

import PersonaManager.Model.PersonaType;

import javax.json.JsonValue;

public interface IPersonaTypeService extends IStandardService {

    public PersonaType getEntity(long id);
}
