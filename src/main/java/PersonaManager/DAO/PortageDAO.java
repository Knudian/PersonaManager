package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPortageDAO;
import PersonaManager.Model.Portage;
import org.springframework.stereotype.Repository;

@Repository
public class PortageDAO extends AbstractDAO implements IPortageDAO {



    @Override
    public Portage create(Portage portage) {
        sessionFactory.getCurrentSession().save(portage);
        sessionFactory.getCurrentSession().refresh(portage);
        return portage;
    }

    @Override
    public Portage getById(long id) {
        return sessionFactory.getCurrentSession().get(Portage.class, id);
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
}
