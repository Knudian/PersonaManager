package PersonaManager.Factory.Interface;

import PersonaManager.Model.PersonaType;

import javax.json.JsonArray;
import java.util.List;

public interface IPersonaTypeFactory {

    public String toJson(PersonaType personaType);

    public PersonaType fromJson(String inputDatas);

    public JsonArray listToJson(List<PersonaType> list);
}
