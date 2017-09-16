package PersonaManager.Service.Interface;

import PersonaManager.Model.GameSystem;
import PersonaManager.Model.Portage;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPortageService {

    public Long create(String entityAsString);

    public JsonValue getById(long id, boolean complete);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public JsonValue getAll(boolean complete);

    public Portage getEntity(long id, boolean complete);

    public Portage init(Portage portage);

    public JsonArray listToJson(List<Portage> list);

    public void createMissingCaracteristicModified(Portage portage);
}
