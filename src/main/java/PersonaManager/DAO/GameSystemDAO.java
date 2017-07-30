package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IGameSystemDAO;
import PersonaManager.Model.GameSystem;
import org.springframework.stereotype.Repository;

@Repository
public class GameSystemDAO extends AbstractDAO implements IGameSystemDAO {

    @Override
    public GameSystem create(GameSystem gameSystem) {
        objectId = sessionFactory.getCurrentSession().save(gameSystem);
        sessionFactory.getCurrentSession().refresh(gameSystem);
        return gameSystem;
    }

    @Override
    public GameSystem getById(long id) {
        return sessionFactory.getCurrentSession().get(GameSystem.class, id);
    }

    @Override
    public void delete(GameSystem gameSystem) {
        sessionFactory.getCurrentSession().remove(gameSystem);
    }

    @Override
    public void update(GameSystem gameSystem) {
        sessionFactory.getCurrentSession().update(gameSystem);
        sessionFactory.getCurrentSession().refresh(gameSystem);
    }
}
