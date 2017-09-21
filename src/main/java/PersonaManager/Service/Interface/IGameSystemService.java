package PersonaManager.Service.Interface;

import PersonaManager.Model.GameSystem;

import javax.json.JsonArray;
import javax.json.JsonValue;

public interface IGameSystemService extends IStandardService {

    public JsonArray getAll();

    public GameSystem getEntity(long id, boolean complete);
}
