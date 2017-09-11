package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.EnumCaracType;
import PersonaManager.Model.GameSystem;
import PersonaManager.Service.Interface.IGameSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import java.util.List;

@Service
public class CaracteristicFactory extends BaseFactory implements ICaracteristicFactory {

    public CaracteristicFactory(){
        super();
    }

    @Autowired
    private IGameSystemService gameSystemService;

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
        Caracteristic caracteristic = new Caracteristic();
        JsonObject jsonObject = this.getStructure(inputDatas);
        GameSystem gameSystem = gameSystemService.getEntity(jsonObject.getInt("gameSystem"), false);
        caracteristic.setGameSystem(gameSystem);
        caracteristic.setDefaultLabel(jsonObject.getString("label"));
        caracteristic.setType(EnumCaracType.getType(jsonObject.getString("type")));
        caracteristic.setMinimum(jsonObject.getString("min"));
        caracteristic.setMaximum(jsonObject.getString("max"));
        return caracteristic;
    }

    @Override
    public JsonArray listToJson(List<Caracteristic> list) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Caracteristic caracteristic : list){
            builder.add(this.getStructure(this.toJson(caracteristic)));
        }
        return builder.build();
    }
}
