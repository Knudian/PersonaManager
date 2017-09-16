package PersonaManager.Factory.Interface;

import PersonaManager.Model.Portage;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IPortageFactory {

    public JsonValue toJson(Portage portage, boolean complete);

    public Portage fromJson(String inputDatas);

    public JsonArray listToJson(List<Portage> list, boolean complete);

    public JsonArray getListOfIdToJson(List<Portage> list);

}
