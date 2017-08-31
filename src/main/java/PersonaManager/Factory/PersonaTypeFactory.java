package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IPersonaTypeFactory;
import PersonaManager.Model.PersonaType;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

@Service
public class PersonaTypeFactory extends BaseFactory implements IPersonaTypeFactory {

    public PersonaTypeFactory() {
        super();
    }

    @Override
    public String toJson(PersonaType personaType) {
        JsonObject model = Json.createObjectBuilder()
                .add("id", personaType.getId())
                .add("name", personaType.getName())
                .add("universeId", personaType.getUniverse().getId())
                .build();
        return null;
    }

    @Override
    public PersonaType fromJson(String inputDatas) {
        return null;
    }

    @Override
    public JsonArray listToJson(List<PersonaType> list) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(PersonaType p : list){
            jsonArray.add(Json.createValue(this.toJson(p)));
        }
        return jsonArray;
    }
}
