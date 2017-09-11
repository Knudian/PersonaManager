package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IGameSystemFactory;
import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Model.GameSystem;
import PersonaManager.Model.MediaFile;
import PersonaManager.Service.Interface.IMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.util.List;

@Service
public class GameSystemFactory extends BaseFactory implements IGameSystemFactory {

    public GameSystemFactory() {
        super();
    }

    @Autowired
    private IMediaFileService mediaFileService;

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
                .add("media", mediaFileService.getById(gameSystem.getIllustration().getId()))
                .add("portageList", portageList)
                .add("caracteristicList", caracteristicList)
                .build();
        return this.write(model);
    }

    @Override
    public GameSystem fromJson(String inputDatas) {
        GameSystem gameSystem = new GameSystem();
        JsonObject jsonObject = this.getStructure(inputDatas);
        gameSystem.setName(jsonObject.getString("name"));
        gameSystem.setShortName(jsonObject.getString("shortName"));
        gameSystem.setWebSite(jsonObject.getString("url"));
        gameSystem.setPortageList(null);
        MediaFile file = null;
        if( jsonObject.getString("media") != null && !jsonObject.getString("media").equals("undefined")) {
            file = mediaFileService.getByFileName(jsonObject.getString("media"));
        }
        gameSystem.setCaracteristicList(null);
        gameSystem.setIllustration(file);
        return gameSystem;
    }

    @Override
    public JsonArray listToJson(List<GameSystem> list, boolean complete) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(GameSystem gameSystem : list){
            builder.add(this.getStructure(this.toJson(gameSystem, false)));
        }
        return builder.build();
    }

    @Override
    public String allToJson(List<GameSystem> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("gameSystem", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }
}
