package PersonaManager.DAO;

import PersonaManager.DAO.Interface.ICaracteristicDAO;
import PersonaManager.Model.Caracteristic;
import org.springframework.stereotype.Repository;

@Repository
public class CaracteristicDAO extends AbstractDAO implements ICaracteristicDAO {

    public CaracteristicDAO(){
        super();
    }

    @Override
    public Caracteristic create(Caracteristic caracteristic) {
        this.objectId = this.currentSession.save(caracteristic);
        this.currentSession.refresh(caracteristic);
        return caracteristic;
    }

    @Override
    public Caracteristic getById(long id) {
        return this.currentSession.get(Caracteristic.class, id);
    }

    @Override
    public void delete(Caracteristic caracteristic) {
        this.currentSession.remove(caracteristic);
    }

    @Override
    public void update(Caracteristic caracteristic) {
        this.currentSession.update(caracteristic);
        this.currentSession.refresh(caracteristic);
    }
}
