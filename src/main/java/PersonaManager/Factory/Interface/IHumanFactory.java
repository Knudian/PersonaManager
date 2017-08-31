package PersonaManager.Factory.Interface;

import PersonaManager.Model.Human;

import javax.json.JsonArray;
import java.util.List;

public interface IHumanFactory {

    public String toJson(Human human, boolean complete);

    public Human fromJson(String inputDatas);

    public JsonArray listToJson(List<Human> list, boolean complete);

    public String allToJson(List<Human> list, boolean complete);

}
