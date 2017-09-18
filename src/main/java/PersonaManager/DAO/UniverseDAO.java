package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IUniverseDAO;
import PersonaManager.Model.Universe;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UniverseDAO extends AbstractDAO implements IUniverseDAO {

    public UniverseDAO() {
        super();
    }

    @Override
    public Universe create(Universe universe) {
        sessionFactory.getCurrentSession().save(universe);
        sessionFactory.getCurrentSession().refresh(universe);
        return universe;
    }

    @Override
    public Universe getById(long id, boolean complete) {

        Universe universe = sessionFactory.getCurrentSession().get(Universe.class, id);
        if( complete ){
            Hibernate.initialize(universe.getPersonaTypeList());
            Hibernate.initialize(universe.getPortageList());
        }
        return universe;
    }

    @Override
    public Universe update(Universe universe) {
        sessionFactory.getCurrentSession().update(universe);
        sessionFactory.getCurrentSession().flush();
        return universe;
    }

    @Override
    public void delete(Universe universe) {
        sessionFactory.getCurrentSession().remove(universe);
    }

    @Override
    public List<Universe> getAll(boolean complete) {
        String q = "SELECT u FROM Universe u";
        Query query = sessionFactory.getCurrentSession().createQuery(q);

        List<Universe> firstList = (List<Universe>) query.getResultList();

        List<Universe> list = new ArrayList<>();

        for(Universe u : firstList){
            list.add(this.getById(u.getId(),  complete));
        }

        return list;
    }
}
