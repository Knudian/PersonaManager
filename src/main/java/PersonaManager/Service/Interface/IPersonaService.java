package PersonaManager.Service.Interface;

import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Persona;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPersonaService extends IStandardService {

    public JsonValue getLastPublicPersonnas(Integer quantity);

    public JsonValue getAll();

    public Persona getEntity(long id, boolean complete);

    public JsonArray listToJson(List<Persona> list);

    public Persona init(Persona persona);

    public void createMissingPersonaCaracteristic(Persona persona, List<CaracteristicModified> list);

    public JsonValue getPublicPersonasForPage(int page, int quantity);

    public int getCountPublic();
}
