package PersonaManager.Service.Interface;

import PersonaManager.Model.Caracteristic;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface ICaracteristicService {

    public Long create(String entityAsString);

    public JsonValue getById(long id);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public Caracteristic getEntity(long id);

    public JsonArray listToJson(List<Caracteristic> list);

    public JsonValue patch(long id, String patchingValues);
}
