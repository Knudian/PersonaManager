package PersonaManager.Factory.Interface;

import PersonaManager.Model.Persona;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPersonaFactory {

    public JsonValue toJson(Persona persona, boolean complete);

    public JsonValue toJsonExtended(Persona persona, boolean complete);

    public Persona fromJson(String inputDatas);

    public JsonArray listToJson(List<Persona> list, boolean complete);

    public JsonArray getListOfIdToJson(List<Persona> list);

    public Persona patch(Persona persona, String patchingValues);

    public JsonArray listToJsonExtended(List<Persona> list, boolean complete);
}
