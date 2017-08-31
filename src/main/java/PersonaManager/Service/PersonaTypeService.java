package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPersonaTypeDAO;
import PersonaManager.Factory.Interface.IPersonaTypeFactory;
import PersonaManager.Model.PersonaType;
import PersonaManager.Service.Interface.IPersonaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaTypeService implements IPersonaTypeService {

    public PersonaTypeService() {}

    @Autowired
    private IPersonaTypeDAO personaTypeDAO;

    @Autowired
    private IPersonaTypeFactory personaTypeFactory;

    @Override
    public Long create(String entityAsString) {
        PersonaType personaType = personaTypeFactory.fromJson(entityAsString);
        personaType = personaTypeDAO.create(personaType);
        return personaType.getId();
    }

    @Override
    public String getById(long id) {
        PersonaType personaType = personaTypeDAO.getById(id);
        return personaTypeFactory.toJson(personaType);
    }

    @Override
    public Boolean update(String entityAsString) {
        try {
            PersonaType personaType = personaTypeFactory.fromJson(entityAsString);
            personaTypeDAO.update(personaType);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            PersonaType personaType = personaTypeFactory.fromJson(entityAsString);
            personaTypeDAO.delete(personaType);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
