package PersonaManager.Factory;

import PersonaManager.Factory.Interface.ICaracteristicModifiedFactory;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.Portage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
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

    @Override
    public String toJson(Portage portage, boolean complete) {
        JsonArray personaList = null;
        JsonArray caracList   = null;

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
        return null;
    }

    @Override
    public JsonArray listToJson(List<Portage> list, boolean complete) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(Portage p : list){
            jsonArray.add(Json.createValue(this.toJson(p, false)));
        }
        return null;
    }

    @Override
    public String allToJson(List<Portage> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("portageList", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }
}
