package PersonaManager.Service;

import PersonaManager.DAO.Interface.ICaracteristicModifiedDAO;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Service.Interface.ICaracteristicModifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CaracteristicModifiedService implements ICaracteristicModifiedService {

    @Autowired
    private ICaracteristicModifiedDAO caracteristicModifiedDAO;

    @Override
    /**
     * @InheritDoc
     */
    public CaracteristicModified create(CaracteristicModified caracteristicModified) {
        return caracteristicModifiedDAO.create(caracteristicModified);
    }

    @Override
    /**
     * @InheritDoc
     */
    public CaracteristicModified getById(long id) {
        return caracteristicModifiedDAO.getById(id);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(CaracteristicModified caracteristicModified) {
        caracteristicModifiedDAO.update(caracteristicModified);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(CaracteristicModified caracteristicModified) {
        caracteristicModifiedDAO.delete(caracteristicModified);
    }
}
