package PersonaManager.Service.Interface;

import PersonaManager.Model.Universe;

import javax.json.JsonValue;
import java.util.List;

public interface IUniverseService {

    public Long create(String entityAsString);

    public JsonValue getById(long id, boolean complete);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public JsonValue getAll(boolean complete);

    public Universe getEntity(long id, boolean complete);
}
