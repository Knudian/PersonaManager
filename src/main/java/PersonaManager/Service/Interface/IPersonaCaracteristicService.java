package PersonaManager.Service.Interface;

import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaCaracteristic;

import javax.json.JsonValue;

public interface IPersonaCaracteristicService extends IStandardService {

    public PersonaCaracteristic getEntity(long id);

    public PersonaCaracteristic createStandard(Persona persona, CaracteristicModified caracteristicModified);
}
