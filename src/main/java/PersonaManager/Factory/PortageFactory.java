package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.GameSystem;
import PersonaManager.Model.Portage;
import PersonaManager.Service.Interface.IGameSystemService;
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

    @Override
    public String toJson(Portage portage, boolean complete) {
        JsonValue personaList = Json.createValue("");
        JsonValue caracList = Json.createValue("");

        if( complete ){
            personaList = personaFactory.listToJson(portage.getPersonaList(), false);
            caracList   = caracteristicModifiedFactory.listToJson(portage.getCaracteristicList());
        }

        JsonObject model = Json.createObjectBuilder()
                .add("id", portage.getId())
                .add("universeId", portage.getUniverse().getId())
                .add("gameSystemId", portage.getGameSystem().getId())
                .add("creationTime", portage.getCreationTime().getTime())
                .add("personaList", personaList)
                .add("caracteristicList", caracList)
                .build();

        return this.write(model);
    }

    @Override
    public Portage fromJson(String inputDatas) {
        Portage portage = new Portage();
        JsonObject jsonObject = this.getStructure(inputDatas);
        portage.setCreationTime(new Timestamp(System.currentTimeMillis()));
        portage.setGameSystem(gameSystemService.getEntity(jsonObject.getInt("gameSystemId"), false));
        portage.setUniverse(universeService.getEntity(jsonObject.getInt("universeId"), false));
        portage.setCaracteristicList(null);
        portage.setPersonaList(null);
        return portage;
    }

    @Override
    public JsonArray listToJson(List<Portage> list, boolean complete) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Portage p : list){
            builder.add(this.getStructure(this.toJson(p, false)));
        }
        return builder.build();
    }

    @Override
    public String allToJson(List<Portage> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("portageList", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }

}
