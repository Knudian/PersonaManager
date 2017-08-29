package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaCaracteristicDAO;
import PersonaManager.Model.PersonaCaracteristic;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonaCaracteristicDAO extends AbstractDAO implements IPersonaCaracteristicDAO {

    public PersonaCaracteristicDAO() {
        super();
    }

    @Override
    public PersonaCaracteristic create(PersonaCaracteristic personaCaracteristic) {
        objectId = sessionFactory.getCurrentSession().save(personaCaracteristic);
        sessionFactory.getCurrentSession().refresh(personaCaracteristic);
        return personaCaracteristic;
    }

    @Override
    public PersonaCaracteristic getById(long id) {
        return sessionFactory.getCurrentSession().get(PersonaCaracteristic.class, id);
    }

    @Override
    public void delete(PersonaCaracteristic personaCaracteristic) {
        sessionFactory.getCurrentSession().remove(personaCaracteristic);
    }

    @Override
    public void update(PersonaCaracteristic personaCaracteristic) {
        sessionFactory.getCurrentSession().update(personaCaracteristic);
        sessionFactory.getCurrentSession().refresh(personaCaracteristic);
    }
}
