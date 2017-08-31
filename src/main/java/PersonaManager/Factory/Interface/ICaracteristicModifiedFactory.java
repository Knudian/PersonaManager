package PersonaManager.Factory.Interface;

import PersonaManager.Model.CaracteristicModified;

import javax.json.JsonArray;
import java.util.List;

public interface ICaracteristicModifiedFactory {

    public String toJson(CaracteristicModified caracteristicModified);

    public CaracteristicModified fromJson(String inputDatas);

    public JsonArray listToJson(List<CaracteristicModified> list);
}
