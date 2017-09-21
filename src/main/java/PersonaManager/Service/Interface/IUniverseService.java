package PersonaManager.Service.Interface;

import PersonaManager.Model.Universe;

import javax.json.JsonValue;
import javax.persistence.UniqueConstraint;
import java.util.List;

public interface IUniverseService extends IStandardService {

    public JsonValue getAll(boolean complete);

    public Universe getEntity(long id, boolean complete);

    public JsonValue statististics();
}
