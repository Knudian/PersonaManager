package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IGameSystemFactory;
import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Model.GameSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.List;

@Service
public class GameSystemFactory extends BaseFactory implements IGameSystemFactory {

    public GameSystemFactory() {
        super();
    }

    @Autowired
    private IMediaFileFactory mediaFileFactory;

    @Override
    public String toJson(GameSystem gameSystem, boolean complete) {
        JsonValue portageList = Json.createValue("");
        JsonValue caracteristicList = Json.createValue("");
        if( complete ){
            // TODO : PortageService
            // TODO : CaracteristicService
        }

        JsonObject model = Json.createObjectBuilder()
                .add("id", gameSystem.getId())
                .add("name", gameSystem.getName())
                .add("shortName", gameSystem.getShortName())
                .add("url", gameSystem.getWebSite())
                .add("media", mediaFileFactory.toJson(gameSystem.getIllustration()))
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
