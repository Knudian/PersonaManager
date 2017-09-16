package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IPersonaTypeFactory;
import PersonaManager.Model.PersonaType;
import PersonaManager.Service.Interface.IUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.util.List;

@Service
public class PersonaTypeFactory extends BaseFactory implements IPersonaTypeFactory {

    public PersonaTypeFactory() {
        super();
    }

    @Autowired
    private IUniverseService universeService;

    @Override
    public JsonValue toJson(PersonaType personaType) {

        JsonObject model = Json.createObjectBuilder()
                .add("id", personaType.getId())
                .add("name", personaType.getName())
                .add("universe", personaType.getUniverse().getId())
                .build();

        return model;
    }

    @Override
    public PersonaType fromJson(String inputDatas) {
        PersonaType personaType = new PersonaType();
        JsonObject jsonObject = this.getStructure(inputDatas);
        personaType.setName(jsonObject.getString("name"));
        personaType.setUniverse(universeService.getEntity(jsonObject.getInt("universe"), false));

        return personaType;
    }

    @Override
    public JsonArray listToJson(List<PersonaType> list) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(PersonaType p : list){
            builder.add(this.toJson(p));
        }
        return builder.build();
    }
}
