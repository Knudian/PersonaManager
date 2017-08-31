package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IPersonaTypeFactory;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Factory.Interface.IUniverseFactory;
import PersonaManager.Model.Universe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
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

    @Override
    public String toJson(Universe universe, boolean complete) {
        JsonArray portageList = null;
        JsonArray personaTypeList = null;

        if( complete ){
            portageList = portageFactory.listToJson(universe.getPortageList(), false);
            personaTypeList = personaTypeFactory.listToJson(universe.getPersonaTypeList());
        }

        JsonObject model = Json.createObjectBuilder()
                .add("id", universe.getId())
                .add("name", universe.getName())
                .add("description", universe.getDescription())
                .add("media", universe.getIllustration().getFilename())
                .add("creationTime", universe.getCreationTime().getTime())
                .add("portageList", portageList)
                .add("personaTypeList", personaTypeList)
                .build();

        return this.write(model);
    }

    @Override
    public Universe fromJson(String inputDatas) {
        return null;
    }

    @Override
    public JsonArray listToJson(List<Universe> list, boolean complete) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(Universe u : list){
            jsonArray.add(Json.createValue(this.toJson(u, false)));
        }
        return jsonArray;
    }

    @Override
    public String allToJson(List<Universe> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("universeList", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }
}
