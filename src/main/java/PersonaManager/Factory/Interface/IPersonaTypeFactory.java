package PersonaManager.Factory.Interface;

import PersonaManager.Model.PersonaType;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPersonaTypeFactory {

    public JsonValue toJson(PersonaType personaType);

    public PersonaType fromJson(String inputDatas);

    public JsonArray listToJson(List<PersonaType> list);
}
