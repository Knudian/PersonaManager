package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Model.Caracteristic;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

@Service
public class CaracteristicFactory extends BaseFactory implements ICaracteristicFactory {

    public CaracteristicFactory(){
        super();
    }

    @Override
    public String toJson(Caracteristic caracteristic) {
        JsonObject model = Json.createObjectBuilder()
                .add("id", caracteristic.getId())
                .add("gameSystem", caracteristic.getGameSystem().getId())
                .add("type", caracteristic.getType().getKey())
                .add("label", caracteristic.getDefaultLabel())
                .add("min", caracteristic.getMinimum())
                .add("max", caracteristic.getMaximum())
                .build();

        return this.write(model);
    }

    @Override
    public Caracteristic fromJson(String inputDatas) {
        // TODO : GameSystemService
        return null;
    }

    @Override
    public JsonArray listToJson(List<Caracteristic> list) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(Caracteristic caracteristic : list){
            jsonArray.add(Json.createValue(caracteristic.getId()));
        }
        return jsonArray;
    }
}
