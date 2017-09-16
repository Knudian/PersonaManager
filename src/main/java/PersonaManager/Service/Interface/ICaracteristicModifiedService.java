package PersonaManager.Service.Interface;

import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Portage;

import javax.json.JsonValue;

public interface ICaracteristicModifiedService {

    public Long create(String entityAsString);

    public CaracteristicModified createStandard(Portage portage, Caracteristic caracteristic);

    public JsonValue getById(long id);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public CaracteristicModified getEntity(long id);

}
