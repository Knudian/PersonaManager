package PersonaManager.Service.Interface;

import PersonaManager.Model.Human;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IHumanService {

    public Long create(String entityAsString);

    public JsonValue getById(long id, boolean complete);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public JsonArray getAll();

    public Human getEntity(long id, boolean complete);

    public JsonValue patch(long id, String patchingValues);
}
