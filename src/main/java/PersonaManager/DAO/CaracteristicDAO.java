package PersonaManager.DAO;

import PersonaManager.DAO.Interface.ICaracteristicDAO;
import PersonaManager.Model.Caracteristic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional
public class CaracteristicDAO implements ICaracteristicDAO {

    public CaracteristicDAO(){}

    @Autowired
    protected SessionFactory sessionFactory;

    private Serializable objectId;

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
