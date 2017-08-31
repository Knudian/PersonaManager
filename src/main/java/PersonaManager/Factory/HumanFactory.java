package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IHumanFactory;
import PersonaManager.Model.Human;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.util.List;

@Service
public class HumanFactory extends BaseFactory implements IHumanFactory {

    public HumanFactory() {
        super();
    }

    @Override
    public String toJson(Human human, boolean complete) {
        JsonArray personaIdList = null;
        if( complete ){
            // TODO : PersonaService
        }
        JsonObject model = Json.createObjectBuilder()
                .add("id", human.getId())
                .add("nick", human.getNick())
                .add("lastConnection", human.getLastConnection().getTime())
                .add("personaList", personaIdList)
                .build();
        return this.write(model);
    }

    @Override
    public Human fromJson(String inputDatas) {
        // Todo : PersonaService
        return null;
    }

    @Override
    public JsonArray listToJson(List<Human> list, boolean complete) {
        JsonArray jsonArray = (JsonArray) Json.createArrayBuilder();
        for(Human human : list){
            jsonArray.add(Json.createValue(this.toJson(human, false)));
        }
        return null;
    }


    @Override
    public String allToJson(List<Human> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("humans", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }

}
