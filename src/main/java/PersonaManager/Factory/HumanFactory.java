package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IHumanFactory;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Model.Human;
import PersonaManager.Service.Interface.IHumanService;
import PersonaManager.Service.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.sql.Timestamp;
import java.util.List;

@Service
public class HumanFactory extends BaseFactory implements IHumanFactory {

    public HumanFactory() {
        super();
    }

    @Autowired
    private IPersonaFactory personaFactory;
    @Autowired
    private IHumanService humanService;

    @Override
    public JsonValue toJson(Human human, boolean complete) {

        human = humanService.getEntity(human.getId(), true);

        JsonValue personaList = personaFactory.getListOfIdToJson(human.getPersonaList());

        if( complete ){
            personaList = personaFactory.listToJson(human.getPersonaList(), false);
        }

        JsonObject model = Json.createObjectBuilder()
                .add("id", human.getId())
                .add("nick", human.getNick())
                .add("lastConnection", human.getLastConnection().getTime())
                .add("personaList", personaList)
                .build();
        return model;
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
        human.setSalt("the salt");
        return human;
    }

    @Override
    public JsonArray listToJson(List<Human> list, boolean complete) {
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }

        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(Human human : list){
            builder.add(this.toJson(human, false));
        }
        return builder.build();
    }

    @Override
    public Human patch(Human human, String patchingValues) {
        JsonObject jsonObject = this.getStructure(patchingValues);

        if( jsonObject.getString("nick") != null ){
            human.setNick( jsonObject.getString("nick") );
        }

        if( jsonObject.getString("email") != null ){
            human.setEmail( jsonObject.getString("email") );
        }

        if( jsonObject.getString("password") != null ){
            human.setPassword( jsonObject.getString("password") );
        }

        return human;
    }
}