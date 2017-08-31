package PersonaManager.Factory.Interface;

import PersonaManager.Model.Persona;

import javax.json.JsonArray;
import java.util.List;

public interface IPersonaFactory {

    public String toJson(Persona persona, boolean complete);

    public Persona fromJson(String inputDatas);

    public JsonArray listToJson(List<Persona> list, boolean complete);

    public String allToJson(List<Persona> list, boolean complete);
}
