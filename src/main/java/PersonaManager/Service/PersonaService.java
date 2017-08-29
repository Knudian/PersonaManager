package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPersonaDAO;
import PersonaManager.Model.Persona;
import PersonaManager.Service.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaDAO personaDAO;

    @Override
    public Persona create(Persona persona) {
        return personaDAO.create(persona);
    }

    @Override
    public Persona getById(long id, boolean lazy) {
        return personaDAO.getById(id, lazy);
    }

    @Override
    public void update(Persona persona) {
        personaDAO.update(persona);
    }

    @Override
    public void delete(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    public List<Persona> getLastPublicPersonnas(Integer quantity){
        return personaDAO.getLastPublicPersona(quantity);
    }
}
