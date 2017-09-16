package PersonaManager.Service;

import PersonaManager.DAO.Interface.IGameSystemDAO;
import PersonaManager.Factory.Interface.IGameSystemFactory;
import PersonaManager.Model.GameSystem;
import PersonaManager.Service.Interface.IGameSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonArray;
import javax.json.JsonValue;

@Service
public class GameSystemService implements IGameSystemService {

    public GameSystemService(){}

    @Autowired
    private IGameSystemFactory gameSystemFactory;
    @Autowired
    private IGameSystemDAO gameSystemDAO;

    @Override
    public Long create(String entityAsString) {
        GameSystem gameSystem = gameSystemDAO.create(gameSystemFactory.fromJson(entityAsString));
        return gameSystem.getId();
    }

    @Override
    public JsonValue getById(long id, boolean complete) {
        return gameSystemFactory.toJson(
                this.getEntity(id, complete),
                complete
        );
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
        GameSystem original = this.getEntity(id, false);
        GameSystem updated  = gameSystemFactory.fromJson(entityAsString);

        if( !updated.equals(original) ){
            if( updated.getName() != null){
                original.setName(updated.getName());
            }
            if(updated.getShortName() != null){
                original.setShortName(updated.getShortName());
            }

            original.setWebSite(updated.getWebSite());
            original.setIllustration(updated.getIllustration());

            original = gameSystemDAO.update(original);

        }
        return gameSystemFactory.toJson(original, false);
    }

    @Override
    public Boolean delete(long id) {
        try {
            gameSystemDAO.delete(this.getEntity(id, false));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public JsonArray getAll() {
        return gameSystemFactory.listToJson(gameSystemDAO.getAll(true), true);
    }

    @Override
    public GameSystem getEntity(long id, boolean complete){
        return gameSystemDAO.getById(id, true);
    }
}
