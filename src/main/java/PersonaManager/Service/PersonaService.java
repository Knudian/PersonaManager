package PersonaManager.Service;

import PersonaManager.DAO.PersonaDAO;
import PersonaManager.Model.Persona;
import PersonaManager.Service.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    /**
     * @InheritDoc
     */
    public Persona create(Persona persona) {
        return personaDAO.create(persona);
    }

    @Override
    /**
     * @InheritDoc
     */
    public Persona getById(long id, boolean lazy) {
        return personaDAO.getById(id, lazy);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(Persona persona) {
        personaDAO.update(persona);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(Persona persona) {
        personaDAO.delete(persona);
    }
}
