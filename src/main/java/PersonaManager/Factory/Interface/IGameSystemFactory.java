package PersonaManager.Factory.Interface;

import PersonaManager.Model.GameSystem;

import javax.json.JsonArray;
import java.util.List;

public interface IGameSystemFactory {

    public String toJson(GameSystem gameSystem, boolean complete);

    public GameSystem fromJson(String inputDatas);

    public JsonArray listToJson(List<GameSystem> list, boolean complete);

    public String allToJson(List<GameSystem> list, boolean complete);

}
