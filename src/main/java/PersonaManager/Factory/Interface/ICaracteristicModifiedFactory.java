package PersonaManager.Factory.Interface;

import PersonaManager.Model.CaracteristicModified;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

public interface ICaracteristicModifiedFactory {

    public JsonObject toJson(CaracteristicModified caracteristicModified);

    public CaracteristicModified fromJson(String inputDatas);

    public JsonArray listToJson(List<CaracteristicModified> list);

    public JsonArray getListOfIdToJson(List<CaracteristicModified> list);

    public CaracteristicModified patch(CaracteristicModified caracteristicModified, String patchingValues);
}
