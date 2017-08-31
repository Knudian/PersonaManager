package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Model.CaracteristicModified;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

@Service
public class CaracteristicModifiedFactory extends BaseFactory implements ICaracteristicModifiedFactory {

    public CaracteristicModifiedFactory() {
        super();
    }

    @Override
    public String toJson(CaracteristicModified caracteristicModified) {
        JsonObject model = Json.createObjectBuilder()
                .add("id", caracteristicModified.getId())
                .add("portageId", caracteristicModified.getPortage().getId())
                .add("caracteristicId", caracteristicModified.getCaracteristic().getId())
                .add("label", caracteristicModified.getLabel())
                .build();
        return this.write(model);
    }

    @Override
    public CaracteristicModified fromJson(String inputDatas) {
        // TODO : CaracteristicFactory
        return null;
    }

    @Override
    public JsonArray listToJson(List<CaracteristicModified> list) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(CaracteristicModified c : list){
            jsonArray.add(Json.createValue(this.toJson(c)));
        }
        return jsonArray;
    }
}
