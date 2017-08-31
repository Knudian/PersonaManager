package PersonaManager.Factory.Interface;

import PersonaManager.Model.Caracteristic;

import javax.json.JsonArray;
import java.util.List;

public interface ICaracteristicFactory {

    public String toJson(Caracteristic caracteristic);

    public Caracteristic fromJson(String inputDatas);

    public JsonArray listToJson(List<Caracteristic> list);
}