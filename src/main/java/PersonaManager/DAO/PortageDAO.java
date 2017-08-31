package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPortageDAO;
import PersonaManager.Model.Portage;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PortageDAO extends AbstractDAO implements IPortageDAO {

    public PortageDAO() {
        super();
    }

    @Override
    public Portage create(Portage portage) {
        sessionFactory.getCurrentSession().save(portage);
        sessionFactory.getCurrentSession().refresh(portage);
        return portage;
    }

    @Override
    public Portage getById(long id, boolean complete) {
        Portage portage = sessionFactory.getCurrentSession().get(Portage.class, id);
        if( complete ){
            Hibernate.initialize(portage.getCaracteristicList());
            Hibernate.initialize(portage.getPersonaList());
        }
        return portage;
    }

    @Override
    public void delete(Portage portage) {
        sessionFactory.getCurrentSession().remove(portage);

    }

    @Override
    public void update(Portage portage) {
        sessionFactory.getCurrentSession().update(portage);
        sessionFactory.getCurrentSession().refresh(portage);
    }

    @Override
    public List<Portage> getAll(boolean complete) {
        String q = "SELECT p FROM Portage p";
        Query query = sessionFactory.getCurrentSession().createQuery(q);
        List<Portage> portageList = (List<Portage>) query.getResultList();

        for(Portage p : portageList){
            if( complete ){
                Hibernate.initialize(p.getPersonaList());
                Hibernate.initialize(p.getCaracteristicList());
            }
        }

        return portageList;
    }
}
