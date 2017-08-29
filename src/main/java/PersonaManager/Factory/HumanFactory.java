package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IHumanFactory;
import PersonaManager.Model.Human;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;

@Service
public class HumanFactory extends BaseFactory implements IHumanFactory{

    public HumanFactory(){
        super();
    }

    @Override
    public String toJson(Human human){

        JsonObject humanModel = Json.createObjectBuilder()
                .add("id", human.getId())
                .add("nick", human.getNick())
                .add("lastConnection", human.getLastConnection().getTime())
                .build();

        return this.write(humanModel);
    }

    /**
     * Used for Matching a SignIn, a Registration.
     *
     * @param inputDatas String
     * @return Human
     */
    @Override
    public Human fromJson(String inputDatas){
        Human human = new Human();
        JsonObject jsonObject = this.getStructure(inputDatas);
        human.setEmail(jsonObject.getString("email"));
        human.setNick(jsonObject.getString("nick"));
        human.setPassword(jsonObject.getString("password"));
        return human;
    }
}
