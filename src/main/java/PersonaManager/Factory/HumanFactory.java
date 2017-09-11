package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IHumanFactory;
import PersonaManager.Model.Human;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.sql.Timestamp;
import java.util.List;

@Service
public class HumanFactory extends BaseFactory implements IHumanFactory {

    public HumanFactory() {
        super();
    }

    @Override
    public String toJson(Human human, boolean complete) {
        JsonValue personaIdList = Json.createValue("");
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
        Human human = new Human();
        JsonObject jsonObject = this.getStructure(inputDatas);
        human.setEmail(jsonObject.getString("email"));
        human.setNick(jsonObject.getString("nick"));
        human.setPassword(jsonObject.getString("password"));
        human.setCreationTime(new Timestamp(System.currentTimeMillis()));
        human.setLastConnection(new Timestamp(System.currentTimeMillis()));
        human.setPersonaList(null);
        human.setSalt("the salt");
        return human;
    }

    @Override
    public JsonArray listToJson(List<Human> list, boolean complete) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Human human : list){
            builder.add(this.getStructure(this.toJson(human, false)));
        }
        return builder.build();
    }


    @Override
    public String allToJson(List<Human> list, boolean complete) {
        JsonObject model = Json.createObjectBuilder()
                .add("humans", this.listToJson(list, complete))
                .build();
        return this.write(model);
    }

}
