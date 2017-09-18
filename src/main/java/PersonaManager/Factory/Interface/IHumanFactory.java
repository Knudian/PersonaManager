package PersonaManager.Factory.Interface;

import PersonaManager.Model.Human;

import javax.json.JsonArray;
import javax.json.JsonValue;
import java.util.List;

public interface IHumanFactory {

    public JsonValue toJson(Human human, boolean complete);

    public Human fromJson(String inputDatas);

    public JsonArray listToJson(List<Human> list, boolean complete);

    public Human patch(Human human, String patchingValues);

}
