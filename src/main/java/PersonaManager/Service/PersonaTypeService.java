package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPersonaTypeDAO;
import PersonaManager.Factory.Interface.IPersonaTypeFactory;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaType;
import PersonaManager.Service.Interface.IPersonaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonValue;

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
    public JsonValue getById(long id) {
        PersonaType personaType = personaTypeDAO.getById(id);
        return personaTypeFactory.toJson(personaType);
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
        PersonaType original = this.getEntity(id);
        PersonaType updated  = personaTypeFactory.fromJson(entityAsString);

        if( !updated.equals(original) ){
            if( updated.getName() != null){
                original.setName(updated.getName());
            }
            if( updated.getUniverse() != null ){
                original.setUniverse(updated.getUniverse());
            }

            original = personaTypeDAO.update(original);
        }
        return personaTypeFactory.toJson(original);
    }

    @Override
    public Boolean delete(long id) {
        try {
            personaTypeDAO.delete(this.getEntity(id));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public PersonaType getEntity(long id) {
        return personaTypeDAO.getById(id);
    }
}
