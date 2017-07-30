package PersonaManager.DAO;

import PersonaManager.DAO.Interface.ICaracteristicDAO;
import PersonaManager.Model.Caracteristic;
import org.springframework.stereotype.Repository;

@Repository
public class CaracteristicDAO extends AbstractDAO implements ICaracteristicDAO {

    @Override
    public Caracteristic create(Caracteristic caracteristic) {
        objectId = sessionFactory.getCurrentSession().save(caracteristic);
        sessionFactory.getCurrentSession().refresh(caracteristic);
        return caracteristic;
    }

    @Override
    public Caracteristic getById(long id) {
        return sessionFactory.getCurrentSession().get(Caracteristic.class, id);
    }

    @Override
    public void delete(Caracteristic caracteristic) {
        sessionFactory.getCurrentSession().remove(caracteristic);
    }

    @Override
    public void update(Caracteristic caracteristic) {
        sessionFactory.getCurrentSession().update(caracteristic);
        sessionFactory.getCurrentSession().refresh(caracteristic);
    }
}