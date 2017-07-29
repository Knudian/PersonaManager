package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaCaracteristicDAO;
import PersonaManager.Model.PersonaCaracteristic;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaCaracteristicDAO extends AbstractDAO implements IPersonaCaracteristicDAO {

    public PersonaCaracteristicDAO() {
        super();
    }

    @Override
    public PersonaCaracteristic create(PersonaCaracteristic personaCaracteristic) {
        this.currentSession.save(personaCaracteristic);
        this.currentSession.refresh(personaCaracteristic);
        return personaCaracteristic;
    }

    @Override
    public PersonaCaracteristic getById(long id) {
        return this.currentSession.get(PersonaCaracteristic.class, id);
    }

    @Override
    public void update(PersonaCaracteristic personaCaracteristic) {
        this.currentSession.update(personaCaracteristic);
        this.currentSession.refresh(personaCaracteristic);
    }

    @Override
    public void delete(PersonaCaracteristic personaCaracteristic) {
        this.currentSession.remove(personaCaracteristic);
    }
}
