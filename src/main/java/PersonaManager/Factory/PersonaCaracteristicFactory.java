package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IPersonaCaracteristicFactory;
import PersonaManager.Model.PersonaCaracteristic;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

@Service
public class PersonaCaracteristicFactory extends BaseFactory implements IPersonaCaracteristicFactory {

    public PersonaCaracteristicFactory() {
        super();
    }

    @Override
    public String toJson(PersonaCaracteristic caracteristic) {
        JsonObject model = Json.createObjectBuilder()
                .add("id", caracteristic.getId())
                .add("value", caracteristic.getValue())
                .add("caracteristicMiD", caracteristic.getCaracteristicModified().getId())
                .build();
        return this.write(model);
    }

    @Override
    public PersonaCaracteristic fromJson(String inputDatas) {
        return null;
    }

    @Override
    public JsonArray listToJson(List<PersonaCaracteristic> list) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(PersonaCaracteristic personaCaracteristic : list){
            jsonArray.add(Json.createValue(this.toJson(personaCaracteristic)));
        }
        return jsonArray;
    }
}
