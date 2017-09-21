package PersonaManager.Service.Interface;

import PersonaManager.Model.Caracteristic;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface ICaracteristicService extends IStandardService  {

    public Caracteristic getEntity(long id);

    public JsonArray listToJson(List<Caracteristic> list);
}
