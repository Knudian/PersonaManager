package PersonaManager.DAO;

import PersonaManager.DAO.Interface.ICaracteristicModifiedDAO;
import PersonaManager.Model.CaracteristicModified;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CaracteristicModifiedDAO extends AbstractDAO implements ICaracteristicModifiedDAO {
    public CaracteristicModifiedDAO() {
        super();
    }

    @Override
    public CaracteristicModified create(CaracteristicModified caracteristicModified) {
        objectId = sessionFactory.getCurrentSession().save(caracteristicModified);
        sessionFactory.getCurrentSession().refresh(caracteristicModified);
        return caracteristicModified;
    }

    @Override
    public CaracteristicModified getById(long id) {
        return sessionFactory.getCurrentSession().get(CaracteristicModified.class, id);
    }

    @Override
    public void delete(CaracteristicModified caracteristicModified) {
        sessionFactory.getCurrentSession().remove(caracteristicModified);
    }

    @Override
    public void update(CaracteristicModified caracteristicModified) {
        sessionFactory.getCurrentSession().update(caracteristicModified);
        sessionFactory.getCurrentSession().refresh(caracteristicModified);
    }
}
