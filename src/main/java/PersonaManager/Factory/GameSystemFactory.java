package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicFactory;
import PersonaManager.Factory.Interface.IGameSystemFactory;
import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.GameSystem;
import PersonaManager.Model.MediaFile;
import PersonaManager.Model.Portage;
import PersonaManager.Service.Interface.ICaracteristicService;
import PersonaManager.Service.Interface.IMediaFileService;
import PersonaManager.Service.Interface.IPortageService;
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
    @Autowired
    private IPortageService portageService;
    @Autowired
    private ICaracteristicService caracteristicService;

    @Override
    public JsonObject toJson(GameSystem gameSystem, boolean complete) {

        JsonValue portageList       = JsonValue.EMPTY_JSON_ARRAY;
        JsonValue caracteristicList = JsonValue.EMPTY_JSON_ARRAY;

        if( complete ){
            portageList = portageService.listToJson(gameSystem.getPortageList());
            caracteristicList = caracteristicService.listToJson(gameSystem.getCaracteristicList());
        }

        JsonValue media = JsonValue.NULL;
        if( gameSystem.getIllustration() != null){
            media = mediaFileService.getById(gameSystem.getIllustration().getId());
        }

        JsonObject model = Json.createObjectBuilder()
                .add("id", gameSystem.getId())
                .add("name", gameSystem.getName())
                .add("shortName", gameSystem.getShortName())
                .add("url", gameSystem.getWebSite())
                .add("media", media)
                .add("portageList", portageList)
                .add("caracteristicList", caracteristicList)
                .build();
        return model;
    }

    @Override
    public GameSystem fromJson(String inputDatas) {
        GameSystem gameSystem = new GameSystem();
        JsonObject jsonObject = this.getStructure(inputDatas);
        gameSystem.setName(jsonObject.getString("name"));
        gameSystem.setShortName(jsonObject.getString("shortName"));
        gameSystem.setWebSite(jsonObject.getString("url"));
        if( jsonObject.getString("media") != null && !jsonObject.getString("media").equals("undefined")) {
            gameSystem.setIllustration(mediaFileService.getByFileName(jsonObject.getString("media")));
        } else {
            gameSystem.setIllustration(null);
        }
        return gameSystem;
    }

    @Override
    public JsonArray listToJson(List<GameSystem> list, boolean complete) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(GameSystem gameSystem : list){
            builder.add(this.toJson(gameSystem, false));
        }
        return builder.build();
    }
}
