package PersonaManager.Service;

import PersonaManager.DAO.PersonaTypeDAO;
import PersonaManager.Model.PersonaType;
import PersonaManager.Service.Interface.IPersonaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaTypeService implements IPersonaTypeService {

    @Autowired
    private PersonaTypeDAO personaTypeDAO;

    @Override
    /**
     * @InheritDoc
     */
    public PersonaType create(PersonaType personaType) {
        return personaTypeDAO.create(personaType);
    }

    @Override
    /**
     * @InheritDoc
     */
    public PersonaType getById(long id) {
        return personaTypeDAO.getById(id);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(PersonaType personaType) {
        personaTypeDAO.update(personaType);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(PersonaType personaType) {
        personaTypeDAO.delete(personaType);
    }
}
