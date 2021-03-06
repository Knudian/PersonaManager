package PersonaManager.Factory.Interface;

import PersonaManager.Model.PersonaCaracteristic;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPersonaCaracteristicFactory {

    public JsonValue toJson(PersonaCaracteristic caracteristic, boolean complete);

    public PersonaCaracteristic fromJson(String inputDatas);

    public JsonArray listToJson(List<PersonaCaracteristic> list, boolean complete);

    public PersonaCaracteristic patch(PersonaCaracteristic personaCaracteristic, String patchingValues);
}

