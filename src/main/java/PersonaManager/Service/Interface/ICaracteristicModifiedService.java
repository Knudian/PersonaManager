package PersonaManager.Service.Interface;

import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Portage;

import javax.json.JsonValue;

public interface ICaracteristicModifiedService extends IStandardService {

    public CaracteristicModified createStandard(Portage portage, Caracteristic caracteristic);

    public CaracteristicModified getEntity(long id);
}
