package PersonaManager.Factory.Interface;

import PersonaManager.Model.PersonaCaracteristic;

import javax.json.JsonArray;
import java.util.List;

public interface IPersonaCaracteristicFactory {

    public String toJson(PersonaCaracteristic caracteristic);

    public PersonaCaracteristic fromJson(String inputDatas);

    public JsonArray listToJson(List<PersonaCaracteristic> list);
}
