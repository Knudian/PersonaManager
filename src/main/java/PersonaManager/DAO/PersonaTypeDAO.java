package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaTypeDAO;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonaTypeDAO extends AbstractDAO implements IPersonaTypeDAO {

    public PersonaTypeDAO() {
        super();
    }

    @Override
    public PersonaType create(PersonaType personaType) {
        sessionFactory.getCurrentSession().save(personaType);
        sessionFactory.getCurrentSession().refresh(personaType);
        return personaType;
    }

    @Override
    public PersonaType getById(long id) {
        return sessionFactory.getCurrentSession().get(PersonaType.class, id);
    }

    @Override
    public PersonaType update(PersonaType personaType) {
        sessionFactory.getCurrentSession().update(personaType);
        sessionFactory.getCurrentSession().flush();
        return personaType;
    }

    @Override
    public void delete(PersonaType personaType) {
        sessionFactory.getCurrentSession().remove(personaType);
    }
}
