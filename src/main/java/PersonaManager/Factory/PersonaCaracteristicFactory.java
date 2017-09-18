package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IPersonaCaracteristicFactory;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaCaracteristic;
import PersonaManager.Service.Interface.ICaracteristicModifiedService;
import PersonaManager.Service.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.util.List;

@Service
public class PersonaCaracteristicFactory extends BaseFactory implements IPersonaCaracteristicFactory {

    public PersonaCaracteristicFactory() {
        super();
    }

    @Autowired
    private ICaracteristicModifiedService caracteristicModifiedService;

    @Autowired
    private IPersonaService personaService;

    @Override
    public JsonValue toJson(PersonaCaracteristic caracteristic) {

        JsonObject model = Json.createObjectBuilder()
                .add("id", caracteristic.getId())
                .add("value", caracteristic.getValue())
                .add("caracteristicMiD", caracteristic.getCaracteristicModified().getId())
                .build();

        return model;
    }

    @Override
    public PersonaCaracteristic fromJson(String inputDatas) {
        PersonaCaracteristic personaCaracteristic = new PersonaCaracteristic();
        JsonObject jsonObject = this.getStructure(inputDatas);
        personaCaracteristic.setCaracteristicModified(caracteristicModifiedService.getEntity(jsonObject.getInt("caracteristicMiD")));
        personaCaracteristic.setPersona(personaService.getEntity(jsonObject.getInt("persona"), false));
        personaCaracteristic.setValue(jsonObject.getString("value"));
        return personaCaracteristic;
    }

    @Override
    public JsonArray listToJson(List<PersonaCaracteristic> list) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(PersonaCaracteristic personaCaracteristic : list) {
            builder.add(this.toJson(personaCaracteristic));
        }
        return builder.build();
    }

    @Override
    public PersonaCaracteristic patch(PersonaCaracteristic personaCaracteristic, String patchingValues) {

        JsonObject jsonObject = this.getStructure(patchingValues);

        // Only the label can be modified.
        if( jsonObject.getString("value") != null){
            personaCaracteristic.setValue(jsonObject.getString("value"));
        }

        return personaCaracteristic;
    }
}
