package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IHumanDAO;
import PersonaManager.Model.Human;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

@Repository
public class HumanDAO extends AbstractDAO implements IHumanDAO {

    @Override
    public Human create(Human human) {
        objectId = sessionFactory.getCurrentSession().save(human);
        sessionFactory.getCurrentSession().refresh(human);
        return human;
    }

    @Override
    public Human getById(long id, boolean lazy) {
        Human human = sessionFactory.getCurrentSession().get(Human.class, id);

        if( lazy ){
            Hibernate.initialize(human.getPersonaList());
        }

        return human;
    }

    @Override
    public void delete(Human human) {
        sessionFactory.getCurrentSession().remove(human);
    }

    @Override
    public void update(Human human) {
        sessionFactory.getCurrentSession().update(human);
        sessionFactory.getCurrentSession().refresh(human);
    }
}
