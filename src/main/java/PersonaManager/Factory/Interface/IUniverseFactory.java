package PersonaManager.Factory.Interface;

import PersonaManager.Model.Universe;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IUniverseFactory {

    public JsonValue toJson(Universe universe, boolean complete);

    public Universe fromJson(String inputDatas);

    public JsonArray listToJson(List<Universe> list, boolean complete);
}
