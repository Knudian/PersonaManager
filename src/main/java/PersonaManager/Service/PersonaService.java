package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPersonaDAO;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Model.Persona;
import PersonaManager.Service.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    public PersonaService() {}

    @Autowired
    private IPersonaDAO personaDAO;

    @Autowired
    private IPersonaFactory personaFactory;

    @Override
    public Long create(String entityAsString) {
        Persona persona = personaFactory.fromJson(entityAsString);
        persona = personaDAO.create(persona);
        return persona.getId();
    }

    @Override
    public String getById(long id, boolean complete) {
        Persona persona = this.getEntity(id, complete);
        return personaFactory.toJson(persona, complete);
    }

    @Override
    public Boolean update(String entityAsString) {
        return null;
    }

    @Override
    public Boolean delete(String entityAsString) {
        try{
            Persona p = personaFactory.fromJson(entityAsString);
            personaDAO.delete(p);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public String getLastPublicPersonnas(Integer quantity) {
        List<Persona> list = personaDAO.getLastPublicPersona(quantity);
        return personaFactory.allToJson(list, false);
    }

    @Override
    public String getAll() {
        List<Persona> list = personaDAO.getAll();
        return personaFactory.allToJson(list, false);
    }

    @Override
    public Persona getEntity(long id, boolean complete) {
        return personaDAO.getById(id, complete);
    }
}
