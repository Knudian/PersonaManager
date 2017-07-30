package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaTypeDAO;
import PersonaManager.Model.PersonaType;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaTypeDAO extends AbstractDAO implements IPersonaTypeDAO {



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
    public void update(PersonaType personaType) {
        sessionFactory.getCurrentSession().update(personaType);
        sessionFactory.getCurrentSession().refresh(personaType);
    }

    @Override
    public void delete(PersonaType personaType) {
        sessionFactory.getCurrentSession().remove(personaType);
    }
}
