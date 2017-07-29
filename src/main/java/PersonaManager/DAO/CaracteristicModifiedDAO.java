package PersonaManager.DAO;

import PersonaManager.DAO.Interface.ICaracteristicModifiedDAO;
import PersonaManager.Model.CaracteristicModified;
import org.springframework.stereotype.Repository;

@Repository
public class CaracteristicModifiedDAO extends AbstractDAO implements ICaracteristicModifiedDAO {

    public CaracteristicModifiedDAO() {
        super();
    }

    @Override
    public CaracteristicModified create(CaracteristicModified caracteristicModified) {
        this.objectId = this.currentSession.save(caracteristicModified);
        this.currentSession.refresh(caracteristicModified);
        return caracteristicModified;
    }

    @Override
    public CaracteristicModified getById(long id) {
        return this.currentSession.get(CaracteristicModified.class, id);
    }

    @Override
    public void delete(CaracteristicModified caracteristicModified) {
        this.currentSession.remove(caracteristicModified);
    }

    @Override
    public void update(CaracteristicModified caracteristicModified) {
        this.currentSession.update(caracteristicModified);
        this.currentSession.refresh(caracteristicModified);
    }
}
