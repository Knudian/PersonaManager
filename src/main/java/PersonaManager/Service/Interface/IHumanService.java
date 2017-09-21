package PersonaManager.Service.Interface;

import PersonaManager.Model.Human;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IHumanService extends IStandardService {

    public JsonArray getAll();

    public Human getEntity(long id, boolean complete);
}
