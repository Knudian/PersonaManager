package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IGameSystemFactory;
import PersonaManager.Model.GameSystem;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

@Service
public class GameSystemFactory extends BaseFactory implements IGameSystemFactory {

    public GameSystemFactory() {
        super();
    }

    @Override
    public String toJson(GameSystem gameSystem, boolean complete) {
        JsonArray portageList = null;
        JsonArray caracteristicList = null;
        if( complete ){
            // TODO : PortageService
            // TODO : CaracteristicService
        }
        JsonObject model = Json.createObjectBuilder()
                .add("id", gameSystem.getId())
                .add("name", gameSystem.getName())
                .add("shortName", gameSystem.getShortName())
                .add("url", gameSystem.getWebSite())
                .add("media", gameSystem.getIllustration().getFilename())
                .add("portageList", portageList)
                .add("caracteristicList", caracteristicList)
                .build();
        return this.write(model);
    }

    @Override
    public GameSystem fromJson(String inputDatas) {
        // TODO : PortageService
        // TODO : CaracteristicService
        return null;
    }

    @Override
    public JsonArray listToJson(List<GameSystem> list, boolean complete) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(GameSystem gameSystem : list){
            jsonArray.add(Json.createValue(gameSystem.getId()));
        }
        return jsonArray;
    }

    @Override
    public String allToJson(List<GameSystem> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("gameSystem", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }
}
