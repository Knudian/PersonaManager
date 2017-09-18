package PersonaManager.Service.Interface;

import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaCaracteristic;

import javax.json.JsonValue;

public interface IPersonaCaracteristicService {

    public Long create(String entityAsString);

    public JsonValue getById(long id);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(String entityAsString);

    public PersonaCaracteristic getEntity(long id);

    public PersonaCaracteristic createStandard(Persona persona, CaracteristicModified caracteristicModified);

    public JsonValue patch(long id, String patchingValues);
}
