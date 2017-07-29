package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IGameSystemDAO;
import PersonaManager.Model.GameSystem;
import org.springframework.stereotype.Repository;

@Repository
public class GameSystemDAO extends AbstractDAO implements IGameSystemDAO {

    public GameSystemDAO() {
        super();
    }

    @Override
    public GameSystem create(GameSystem gameSystem) {
        this.currentSession.save(gameSystem);
        this.currentSession.refresh(gameSystem);
        return gameSystem;
    }

    @Override
    public GameSystem getById(long id) {
        return this.currentSession.get(GameSystem.class, id);
    }

    @Override
    public void delete(GameSystem gameSystem) {
        this.currentSession.remove(gameSystem);
    }

    @Override
    public void update(GameSystem gameSystem) {
        this.currentSession.update(gameSystem);
        this.currentSession.refresh(gameSystem);
    }
}
