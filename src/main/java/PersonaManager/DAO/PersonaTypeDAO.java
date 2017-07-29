package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaTypeDAO;
import PersonaManager.Model.PersonaType;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaTypeDAO extends AbstractDAO implements IPersonaTypeDAO {

    public PersonaTypeDAO() {
        super();
    }

    @Override
    public PersonaType create(PersonaType personaType) {
        this.currentSession.save(personaType);
        this.currentSession.refresh(personaType);
        return personaType;
    }

    @Override
    public PersonaType getById(long id) {
        return this.currentSession.get(PersonaType.class, id);
    }

    @Override
    public void update(PersonaType personaType) {
        this.currentSession.update(personaType);
        this.currentSession.refresh(personaType);
    }

    @Override
    public void delete(PersonaType personaType) {
        this.currentSession.remove(personaType);
    }
}
