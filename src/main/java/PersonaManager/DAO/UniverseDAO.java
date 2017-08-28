package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IUniverseDAO;
import PersonaManager.Model.Universe;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

@Repository
public class UniverseDAO extends AbstractDAO implements IUniverseDAO {



    @Override
    public Universe create(Universe universe) {
        sessionFactory.getCurrentSession().save(universe);
        sessionFactory.getCurrentSession().refresh(universe);
        return universe;
    }

    @Override
    public Universe getById(long id, boolean lazy) {
        Universe universe = sessionFactory.getCurrentSession().get(Universe.class, id);
        /*if( lazy ){
            Hibernate.initialize(universe.getPersonaTypeList());
        }*/
        return universe;
    }

    @Override
    public void update(Universe universe) {
        sessionFactory.getCurrentSession().update(universe);
        sessionFactory.getCurrentSession().refresh(universe);
    }

    @Override
    public void delete(Universe universe) {
        sessionFactory.getCurrentSession().remove(universe);
    }
}
