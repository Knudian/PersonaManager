package PersonaManager.Service;

import PersonaManager.DAO.Interface.IGameSystemDAO;
import PersonaManager.Factory.Interface.IGameSystemFactory;
import PersonaManager.Model.GameSystem;
import PersonaManager.Service.Interface.IGameSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String getById(long id, boolean complete) {
        return gameSystemFactory.toJson(
                this.getEntity(id, complete),
                complete
        );
    }

    @Override
    public Boolean update(String entityAsString) {
        try {
            gameSystemDAO.update(gameSystemFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            gameSystemDAO.delete(gameSystemFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public String getAll() {
        return gameSystemFactory.allToJson(gameSystemDAO.getAll(true), true);
    }

    @Override
    public GameSystem getEntity(long id, boolean complete){
        return gameSystemDAO.getById(id, true);
    }
}
