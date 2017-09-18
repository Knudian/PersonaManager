package PersonaManager.Factory.Interface;

import PersonaManager.Model.GameSystem;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IGameSystemFactory {

    public JsonValue toJson(GameSystem gameSystem, boolean complete);

    public GameSystem fromJson(String inputDatas);

    public JsonArray listToJson(List<GameSystem> list, boolean complete);

    public GameSystem patch(GameSystem gameSystem, String patchingValues);

}
