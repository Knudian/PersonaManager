package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.*;
import PersonaManager.Service.Interface.IGameSystemService;
import PersonaManager.Service.Interface.IPortageService;
import PersonaManager.Service.Interface.IUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortageFactory extends BaseFactory implements IPortageFactory {

    public PortageFactory() {
        super();
    }

    @Autowired
    private IPersonaFactory personaFactory;
    @Autowired
    private ICaracteristicModifiedFactory caracteristicModifiedFactory;
    @Autowired
    private IGameSystemService gameSystemService;
    @Autowired
    private IUniverseService universeService;
    @Autowired
    private IPortageService portageService;


    @Override
    public JsonValue toJson(Portage portage, boolean complete) {

        JsonValue personaList   = JsonValue.EMPTY_JSON_ARRAY;
        JsonValue caracList     = JsonValue.EMPTY_JSON_ARRAY;

        JsonValue gamesystem    = Json.createValue(portage.getGameSystem().getId());
        JsonValue universe      = Json.createValue(portage.getUniverse().getId());
        if( complete ){

            portage = portageService.getEntity(portage.getId(), true);
            personaList = personaFactory.getListOfIdToJson(portage.getPersonaList());
            caracList   = caracteristicModifiedFactory.getListOfIdToJson(portage.getCaracteristicList());

            gamesystem = gameSystemService.getById(portage.getGameSystem().getId(), false);
            universe    = universeService.getById(portage.getUniverse().getId(), false);
        }

        JsonObject model = Json.createObjectBuilder()
                .add("id", portage.getId())
                .add("universe", universe)
                .add("gamesystem", gamesystem)
                .add("creationTime", portage.getCreationTime().getTime())
                .add("personaList", personaList)
                .add("caracteristicList", caracList)
                .build();

        return model;
    }

    @Override
    public Portage fromJson(String inputDatas) {
        Portage portage = new Portage();
        JsonObject jsonObject = this.getStructure(inputDatas);
        portage.setCreationTime(new Timestamp(System.currentTimeMillis()));
        portage.setGameSystem(gameSystemService.getEntity(jsonObject.getInt("gamesystem"), false));
        portage.setUniverse(universeService.getEntity(jsonObject.getInt("universe"), false));
        return portage;
    }

    @Override
    public JsonArray listToJson(List<Portage> list, boolean complete) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Portage p : list){
            builder.add(this.toJson(p, complete));
        }
        return builder.build();
    }

    @Override
    public JsonArray getListOfIdToJson(List<Portage> list) {
        if( list.isEmpty() ){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Portage p : list){
            builder.add(p.getId());
        }
        return builder.build();
    }
}
