package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPersonaCaracteristicDAO;
import PersonaManager.Model.PersonaCaracteristic;
import PersonaManager.Service.Interface.IPersonaCaracteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaCaracteristicService implements IPersonaCaracteristicService {

    @Autowired
    private IPersonaCaracteristicDAO personaCaracteristicDAO;

    @Override
    /**
     * @InheritDoc
     */
    public PersonaCaracteristic create(PersonaCaracteristic personaCaracteristic) {
        return personaCaracteristicDAO.create(personaCaracteristic);
    }

    @Override
    /**
     * @InheritDoc
     */
    public PersonaCaracteristic getById(long id) {
        return personaCaracteristicDAO.getById(id);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(PersonaCaracteristic personaCaracteristic) {
        personaCaracteristicDAO.update(personaCaracteristic);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(PersonaCaracteristic personaCaracteristic) {
        personaCaracteristicDAO.delete(personaCaracteristic);
    }
}
