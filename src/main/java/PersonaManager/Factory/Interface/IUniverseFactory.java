package PersonaManager.Factory.Interface;

import PersonaManager.Model.Universe;

import javax.json.JsonArray;
import java.util.List;

public interface IUniverseFactory {

    public String toJson(Universe universe, boolean complete);

    public Universe fromJson(String inputDatas);

    public JsonArray listToJson(List<Universe> list, boolean complete);

    public String allToJson(List<Universe> list, boolean complete);
}
