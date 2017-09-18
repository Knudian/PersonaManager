package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Factory.Interface.IGameSystemFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.EnumCaracType;
import PersonaManager.Model.GameSystem;
import PersonaManager.Service.Interface.IGameSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.util.List;

@Service
public class CaracteristicFactory extends BaseFactory implements ICaracteristicFactory {

    public CaracteristicFactory(){
        super();
    }

    @Autowired
    private IGameSystemFactory gameSystemFactory;

    @Autowired
    private IGameSystemService gameSystemService;

    @Override
    public JsonObject toJson(Caracteristic caracteristic, boolean complete) {

        // Force the system to lazyLoad the gameSystem entity.
        JsonValue gameSystem = gameSystemFactory.toJson(caracteristic.getGameSystem(), false);

        JsonObject model = Json.createObjectBuilder()
                .add("id", caracteristic.getId())
                .add("gamesystem", gameSystem)
                .add("type", caracteristic.getType().getKey())
                .add("label", caracteristic.getDefaultLabel())
                .add("min", caracteristic.getMinimum())
                .add("max", caracteristic.getMaximum())
                .build();
        return model;
    }

    @Override
    public Caracteristic fromJson(String inputDatas) {
        Caracteristic caracteristic = new Caracteristic();
        JsonObject jsonObject = this.getStructure(inputDatas);
        GameSystem gameSystem = gameSystemService.getEntity(jsonObject.getInt("gamesystem"), false);
        caracteristic.setGameSystem(gameSystem);
        caracteristic.setDefaultLabel(jsonObject.getString("label"));
        caracteristic.setType(EnumCaracType.getType(jsonObject.getString("type")));
        caracteristic.setMinimum(jsonObject.getString("min"));
        caracteristic.setMaximum(jsonObject.getString("max"));
        return caracteristic;
    }

    @Override
    public JsonArray listToJson(List<Caracteristic> list) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Caracteristic caracteristic : list){
            builder.add(this.toJson(caracteristic, false));
        }
        return builder.build();
    }

    @Override
    public JsonArray getListOfIdToJson(List<Caracteristic> list) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Caracteristic caracteristic : list){
            builder.add(caracteristic.getId());
        }
        return builder.build();
    }

    @Override
    public Caracteristic patch(Caracteristic caracteristic, String patchingValues) {

        JsonObject jsonObject = this.getStructure(patchingValues);

        if( jsonObject.getString("defaultLabel") != null){
            caracteristic.setDefaultLabel( jsonObject.getString("defaultLabel"));
        }
        if( jsonObject.getString("maximum") != null) {
            caracteristic.setMaximum( jsonObject.getString("maximum"));
        }
        if( jsonObject.getString("minimum") != null){
            caracteristic.setMinimum( jsonObject.getString("minimum"));
        }
        if( jsonObject.getString("type") != null){
            caracteristic.setType(EnumCaracType.getType(jsonObject.getString("type")));
        }

        return caracteristic;
    }
}
