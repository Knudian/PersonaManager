package PersonaManager.Service.Interface;

import PersonaManager.Model.GameSystem;

import javax.json.JsonArray;
import javax.json.JsonValue;

public interface IGameSystemService {

    public Long create(String entityAsString);

    public JsonValue getById(long id, boolean complete);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public JsonArray getAll();

    public GameSystem getEntity(long id, boolean complete);

    public JsonValue patch(long id, String patchingValues);
}
