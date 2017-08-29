package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IGameSystemDAO;
import PersonaManager.Model.GameSystem;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GameSystemDAO extends AbstractDAO implements IGameSystemDAO {

    public GameSystemDAO() {
        super();
    }

    @Override
    public GameSystem create(GameSystem gameSystem) {
        objectId = sessionFactory.getCurrentSession().save(gameSystem);
        sessionFactory.getCurrentSession().refresh(gameSystem);
        return gameSystem;
    }

    @Override
    public GameSystem getById(long id, boolean lazy) {
        GameSystem gs = sessionFactory.getCurrentSession().get(GameSystem.class, id);
        if( !lazy ) {
            Hibernate.initialize(gs.getCaracteristicList());
            Hibernate.initialize(gs.getPortageList());
        }
        return gs;
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

    @Override
    public List<GameSystem> getAll(boolean lazy) {
        String q = "SELECT gs FROM GameSystem gs";
        Query query = sessionFactory.getCurrentSession().createQuery(q);

        return (List<GameSystem>) query.getResultList();
    }
}
