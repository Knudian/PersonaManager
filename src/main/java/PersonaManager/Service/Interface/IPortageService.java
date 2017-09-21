package PersonaManager.Service.Interface;

import PersonaManager.Model.GameSystem;
import PersonaManager.Model.Portage;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPortageService extends IStandardService {

    public JsonValue getAll(boolean complete);

    public Portage getEntity(long id, boolean complete);

    public Portage init(Portage portage);

    public JsonArray listToJson(List<Portage> list, boolean complete);

    public void createMissingCaracteristicModified(Portage portage);
}
