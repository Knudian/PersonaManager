package PersonaManager.Service;

import PersonaManager.DAO.Interface.IHumanDAO;
import PersonaManager.Factory.Interface.IHumanFactory;
import PersonaManager.Model.Human;
import PersonaManager.Service.Interface.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonArray;
import javax.json.JsonValue;

@Service
public class HumanService implements IHumanService {

    public HumanService() {}

    @Autowired
    private IHumanFactory humanFactory;
    @Autowired
    private IHumanDAO humanDAO;

    @Override
    public Long create(String entityAsString) {
        Human human = humanDAO.create(humanFactory.fromJson(entityAsString));
        return human.getId();
    }

    @Override
    public JsonValue getById(long id, boolean complete) {
        return humanFactory.toJson(
                this.getEntity(id, complete),
                complete
        );
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
        Human original = this.getEntity(id, false);
        Human updated  = humanFactory.fromJson(entityAsString);

        if( !updated.equals(original) ){
            if( updated.getNick() != null) {
                original.setNick(updated.getNick());
            }
            if( updated.getEmail() != null) {
                original.setEmail(updated.getPassword());
            }
            original = humanDAO.update(original);
        }
        return humanFactory.toJson(original, false);
    }

    @Override
    public Boolean delete(long id) {
        try {
            humanDAO.delete(this.getEntity(id, false));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public JsonArray getAll() {
        return humanFactory.listToJson(humanDAO.getAll(), false);
    }

    @Override
    public Human getEntity(long id, boolean complete){
        return humanDAO.getById(id, complete);
    }

    @Override
    public JsonValue patch(long id, String patchingValues) {
        Human human = humanFactory.patch(this.getEntity(id, false), patchingValues);

        return humanFactory.toJson(humanDAO.update(human), false);
    }
}
