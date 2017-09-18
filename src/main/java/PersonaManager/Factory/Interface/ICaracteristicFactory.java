package PersonaManager.Factory.Interface;

import PersonaManager.Model.Caracteristic;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

public interface ICaracteristicFactory {

    public JsonObject toJson(Caracteristic caracteristic, boolean complete);

    public JsonArray getListOfIdToJson(List<Caracteristic> list);

    public Caracteristic fromJson(String inputDatas);

    public JsonArray listToJson(List<Caracteristic> list);

    public Caracteristic patch(Caracteristic caracteristic, String patchingValues);
}