package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Factory.Interface.IPersonaCaracteristicFactory;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.List;

@Service
public class PersonaFactory extends BaseFactory implements IPersonaFactory {

    public PersonaFactory() {
        super();
    }

    @Autowired
    private IMediaFileFactory mediaFileFactory;

    private IPersonaCaracteristicFactory personaCaracteristicFactory;

    @Override
    public String toJson(Persona persona, boolean complete) {
        JsonValue caracteristicArray = Json.createValue("");
        if( complete ){
            caracteristicArray = personaCaracteristicFactory.listToJson(persona.getCaracteristicList());
        }
        JsonObject model = Json.createObjectBuilder()
                .add("id", persona.getId())
                .add("owner", persona.getOwner().getId())
                .add("isPublic", persona.isPublic())
                .add("firstName", persona.getFirstName())
                .add("lastName", persona.getLastname())
                .add("lastUpdate", persona.getLastUpdate().getTime())
                .add("creationTime", persona.getCreationTime().getTime())
                .add("media", mediaFileFactory.toJson(persona.getImage()))
                .add("type", persona.getPersonaType().getId())
                .add("portageId", persona.getPortage().getId())
                .add("gender", persona.getGender().getKey())
                .add("caracteristics", caracteristicArray)
                .add("description", (persona.getDescription() == null ? "" : persona.getDescription()))
                .build();
        return this.write(model);
    }

    @Override
    public Persona fromJson(String inputDatas) {
        // TODO : Create Persona from Json Values
        return null;
    }

    @Override
    public JsonArray listToJson(List<Persona> list, boolean complete) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(Persona p : list){
            jsonArray.add(Json.createValue(this.toJson(p, false)));
        }
        return jsonArray;
    }

    @Override
    public String allToJson(List<Persona> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("personas", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }
}
