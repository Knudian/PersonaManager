package PersonaManager.Factory;

import PersonaManager.Factory.Interface.*;
import PersonaManager.Model.EnumPersonaGender;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaCaracteristic;
import PersonaManager.Service.Interface.IHumanService;
import PersonaManager.Service.Interface.IPersonaService;
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
    @Autowired
    private IPersonaService personaService;
    @Autowired
    private IPortageFactory portageFactory;

    @Override
    public JsonValue toJson(Persona persona, boolean complete) {
        JsonValue caracteristicArray = JsonValue.EMPTY_JSON_ARRAY;
        JsonValue portage = Json.createValue(persona.getPortage().getId());

        if( complete ){
            persona = personaService.getEntity(persona.getId(), true);
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
                .add("portage", portage)
                .add("gender", persona.getGender().getKey())
                .add("caracteristics", caracteristicArray)
                .add("description", (persona.getDescription() == null ? "" : persona.getDescription()))
                .build();
        return model;
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
        persona.setCreationTime(new Timestamp(System.currentTimeMillis()));
        persona.setDescription(jsonObject.getString("description"));
        persona.setGender(EnumPersonaGender.getGender(jsonObject.getString("gender")));
        persona.setPortage(portageService.getEntity(jsonObject.getInt("portage"), false));
        return persona;
    }

    @Override
    public JsonArray listToJson(List<Persona> list, boolean complete) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Persona p : list){
            builder.add(this.toJson(p, false));
        }
        return builder.build();
    }

    @Override
    public JsonArray getListOfIdToJson(List<Persona> list) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Persona p : list){
            builder.add(p.getId());
        }
        return builder.build();
    }

    @Override
    public Persona patch(Persona persona, String patchingValues) {

        JsonObject jsonObject = this.getStructure(patchingValues);

        try {
            if (jsonObject.getString("firstName") != null) {
                persona.setFirstName(jsonObject.getString("firstName"));
            }
        } catch (Exception e) {
            // do nothing
        }

        try {
            if( jsonObject.getString("lastName") != null){
                persona.setLastName(jsonObject.getString("lastName"));
            }
        } catch (Exception e) {
            // do nothing
        }

        try {
            if( jsonObject.getString("gender") != null){
                persona.setGender(EnumPersonaGender.getGender( jsonObject.getString("gender")));
            }
        } catch (Exception e) {
            // do nothing
        }

        try {
            if( jsonObject.getBoolean("isPublic") != persona.isPublic()) {
                boolean b = jsonObject.getBoolean("isPublic");
                if (b) {
                    persona.setPublic();
                } else {
                    persona.setPrivate();
                }
            }

        } catch (Exception e) {
            // do nothing
        }

        return persona;

    }
}
