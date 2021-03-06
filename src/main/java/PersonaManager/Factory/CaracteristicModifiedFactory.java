package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Service.Interface.ICaracteristicService;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
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

    @Autowired
    private IPortageFactory portageFactory;
    @Autowired
    private ICaracteristicFactory caracteristicFactory;

    @Override
    public JsonObject toJson(CaracteristicModified caracteristicModified) {
        JsonValue caracteristic = caracteristicFactory.toJson(caracteristicModified.getCaracteristic(), false);

        JsonObject model = Json.createObjectBuilder()
                .add("id", caracteristicModified.getId())
                .add("caracteristic", caracteristic)
                .add("label", caracteristicModified.getLabel() == null ? JsonValue.NULL : Json.createValue(caracteristicModified.getLabel()))
                .add("portage", caracteristicModified.getPortage().getId())
                .build();
        return model;
    }

    @Override
    public JsonObject toInnerJson(CaracteristicModified caracteristicModified){

        JsonValue caracteristic = caracteristicFactory.toJson(caracteristicModified.getCaracteristic(), false);

        JsonObject model = Json.createObjectBuilder()
                .add("caracteristic", caracteristic)
                .add("label", caracteristicModified.getLabel() == null ? "null" : caracteristicModified.getLabel())
                .build();
        return model;
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
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(CaracteristicModified c : list){
            builder.add(this.toJson(c));
        }
        return builder.build();
    }

    @Override
    public JsonArray getListOfIdToJson(List<CaracteristicModified> list){
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(CaracteristicModified c : list){
            builder.add(c.getId());
        }
        return builder.build();
    }

    @Override
    public CaracteristicModified patch(CaracteristicModified caracteristicModified, String patchingValues) {
        JsonObject jsonObject = this.getStructure(patchingValues);

        // Only the label can be modified.
        try {
            if (jsonObject.getString("label") != null) {
                caracteristicModified.setLabel(jsonObject.getString("label"));
            }
        } catch (Exception e){
            // do nothing
        }
        return caracteristicModified;
    }
}
