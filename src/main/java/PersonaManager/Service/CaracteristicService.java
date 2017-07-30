package PersonaManager.Service;

import PersonaManager.DAO.CaracteristicDAO;
import PersonaManager.Model.Caracteristic;
import PersonaManager.Service.Interface.ICaracteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CaracteristicService implements ICaracteristicService {

    @Autowired
    private CaracteristicDAO caracteristicDAO;

    public CaracteristicService() {
    }

    @Override
    /**
     * @InheritDoc
     */
    public Caracteristic create(Caracteristic caracteristic) {
        return caracteristicDAO.create(caracteristic);
    }

    @Override
    /**
     * @InheritDoc
     */
    public Caracteristic getById(long id) {
        return caracteristicDAO.getById(id);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(Caracteristic caracteristic) {
        caracteristicDAO.update(caracteristic);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(Caracteristic caracteristic) {
        caracteristicDAO.delete(caracteristic);
    }
}
