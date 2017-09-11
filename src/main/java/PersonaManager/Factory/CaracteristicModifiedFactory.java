package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Service.Interface.ICaracteristicService;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import java.util.List;

@Service
public class CaracteristicModifiedFactory extends BaseFactory implements ICaracteristicModifiedFactory {

    public CaracteristicModifiedFactory() {
        super();
    }

    @Autowired
    private IPortageService portageService;

    @Autowired
    private ICaracteristicService caracteristicService;

    @Override
    public String toJson(CaracteristicModified caracteristicModified) {
        JsonObject model = Json.createObjectBuilder()
                .add("id", caracteristicModified.getId())
                .add("portageId", caracteristicModified.getPortage().getId())
                .add("caracteristicId", caracteristicModified.getCaracteristic().getId())
                .add("label", caracteristicModified.getLabel() == null ? "null" : caracteristicModified.getLabel())
                .build();
        return this.write(model);
    }

    @Override
    public CaracteristicModified fromJson(String inputDatas) {
        JsonObject jsonObject = this.getStructure(inputDatas);
        CaracteristicModified caracteristicModified = new CaracteristicModified();

        caracteristicModified.setPortage(portageService.getEntity(jsonObject.getInt("portageId"), false));
        caracteristicModified.setCaracteristic(caracteristicService.getEntity(jsonObject.getInt("caracteristicId")));
        caracteristicModified.setLabel(jsonObject.getString("label"));

        return caracteristicModified;
    }

    @Override
    public JsonArray listToJson(List<CaracteristicModified> list) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(CaracteristicModified c : list){
            builder.add(this.getStructure(this.toJson(c)));
        }
        return builder.build();
    }
}
