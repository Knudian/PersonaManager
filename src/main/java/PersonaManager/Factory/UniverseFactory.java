package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Factory.Interface.IPersonaTypeFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Factory.Interface.IUniverseFactory;
import PersonaManager.Model.MediaFile;
import PersonaManager.Model.Universe;
import PersonaManager.Service.Interface.IMediaFileService;
import PersonaManager.Service.Interface.IUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UniverseFactory extends BaseFactory implements IUniverseFactory {

    public UniverseFactory() {
        super();
    }

    @Autowired
    private IPortageFactory portageFactory;
    @Autowired
    private IPersonaTypeFactory personaTypeFactory;
    @Autowired
    private IMediaFileFactory mediaFileFactory;
    @Autowired
    private IMediaFileService mediaFileService;
    @Autowired
    private IUniverseService universeService;

    @Override
    public JsonValue toJson(Universe universe, boolean complete) {

        JsonValue portageList       = JsonValue.EMPTY_JSON_ARRAY;
        JsonValue personaTypeList   = JsonValue.EMPTY_JSON_ARRAY;

        if( complete ){
            universe = universeService.getEntity(universe.getId(), true);

            portageList = portageFactory.getListOfIdToJson(universe.getPortageList());
            personaTypeList = personaTypeFactory.listToJson(universe.getPersonaTypeList());
        }

        JsonObject model = Json.createObjectBuilder()
                .add("id", universe.getId())
                .add("name", universe.getName())
                .add("description", universe.getDescription())
                .add("media", mediaFileFactory.toJson(universe.getIllustration()))
                .add("creationTime", universe.getCreationTime().getTime())
                .add("portageList", portageList)
                .add("personaTypeList", personaTypeList)
                .build();

        return model;
    }

    @Override
    public Universe fromJson(String inputDatas) {
        Universe universe = new Universe();
        JsonObject jsonObject = this.getStructure(inputDatas);
        universe.setCreationTime(new Timestamp(System.currentTimeMillis()));
        universe.setName(jsonObject.getString("name"));
        universe.setDescription(jsonObject.getString("description"));
        MediaFile file = null;
        if( !jsonObject.getString("media").equals("undefined")) {
            file = mediaFileService.getByFileName(jsonObject.getString("media"));
        }
        universe.setIllustration(file);
        return universe;
    }

    @Override
    public JsonArray listToJson(List<Universe> list, boolean complete) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Universe u : list){
            builder.add(this.toJson(u, false));
        }
        return builder.build();
    }
}
