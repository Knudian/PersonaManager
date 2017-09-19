package PersonaManager.Service.Interface;

import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Persona;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPersonaService {

    public Long create(String entityAsString);

    public JsonValue getById(long id, boolean complete);

    public JsonValue update(String entityAsString, long id);

    public Boolean delete(long id);

    public JsonValue getLastPublicPersonnas(Integer quantity);

    public JsonValue getAll();

    public Persona getEntity(long id, boolean complete);

    public JsonArray listToJson(List<Persona> list);

    public Persona init(Persona persona);

    public void createMissingPersonaCaracteristic(Persona persona, List<CaracteristicModified> list);

    public JsonValue patch(long id, String patchingValues);

    public JsonValue getPublicPersonasForPage(int page, int quantity);

    public int getCount();
}
