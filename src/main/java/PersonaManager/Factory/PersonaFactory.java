package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Factory.Interface.IPersonaCaracteristicFactory;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Model.EnumPersonaGender;
import PersonaManager.Model.Persona;
import PersonaManager.Service.Interface.IHumanService;
import PersonaManager.Service.Interface.IPersonaTypeService;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.sql.Timestamp;
import java.util.List;

@Service
public class PersonaFactory extends BaseFactory implements IPersonaFactory {

    public PersonaFactory() {
        super();
    }

    @Autowired
    private IMediaFileFactory mediaFileFactory;

    @Autowired
    private IPersonaTypeService personaTypeService;

    @Autowired
    private IPersonaCaracteristicFactory personaCaracteristicFactory;
    @Autowired
    private IHumanService humanService;
    @Autowired
    private IPortageService portageService;

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
                .add("lastName", persona.getLastName())
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
        Persona persona = new Persona();
        JsonObject jsonObject = this.getStructure(inputDatas);
        persona.setPersonaType(personaTypeService.getEntity(jsonObject.getInt("type")));
        persona.setOwner(humanService.getEntity(jsonObject.getInt("owner"), false));
        if( jsonObject.getBoolean("isPublic")){
            persona.setPublic();
        } else {
            persona.setPrivate();
        }
        persona.setFirstName(jsonObject.getString("firstName"));
        persona.setLastName(jsonObject.getString("lastName"));
        Timestamp creationTime = new Timestamp(System.currentTimeMillis());
        persona.setDescription(jsonObject.getString("description"));
        persona.setGender(EnumPersonaGender.getGender(jsonObject.getString("gender")));
        persona.setPortage(portageService.getEntity(jsonObject.getInt("portageId"), false));
        persona.setCaracteristicList(null);
        return persona;
    }

    @Override
    public JsonArray listToJson(List<Persona> list, boolean complete) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Persona p : list){
            builder.add(this.getStructure(this.toJson(p, false)));
        }
        return builder.build();
    }

    @Override
    public String allToJson(List<Persona> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("personas", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }
}
