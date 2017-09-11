package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPersonaDAO;
import PersonaManager.Factory.Interface.IPersonaCaracteristicFactory;
import PersonaManager.Factory.Interface.IPersonaFactory;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaCaracteristic;
import PersonaManager.Model.Portage;
import PersonaManager.Service.Interface.IPersonaCaracteristicService;
import PersonaManager.Service.Interface.IPersonaService;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    public PersonaService() {}

    @Autowired
    private IPersonaDAO personaDAO;

    @Autowired
    private IPersonaFactory personaFactory;
    @Autowired
    private IPortageService portageService;
    @Autowired
    private IPersonaCaracteristicService personaCaracteristicService;
    @Autowired
    private IPersonaCaracteristicFactory personaCaracteristicFactory;

    @Override
    public Long create(String entityAsString) {
        Persona persona = personaFactory.fromJson(entityAsString);
        persona = personaDAO.create(persona);
        persona = this.init(persona);
        return persona.getId();
    }

    @Override
    public String getById(long id, boolean complete) {
        Persona persona = this.getEntity(id, complete);
        return personaFactory.toJson(persona, complete);
    }

    @Override
    public String update(String entityAsString, long id) {
        Persona original = this.getEntity(id, false);
        Persona updated  = personaFactory.fromJson(entityAsString);

        if( !updated.equals(original)){
            original.setImage(updated.getImage());
            original.setGender(updated.getGender());
            original.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            original.setDescription(updated.getDescription());
            original.setFirstName(updated.getFirstName());
            original.setLastName(updated.getLastName());
            original.setPersonaType(updated.getPersonaType());

            original = personaDAO.update(original);
        }

        return personaFactory.toJson(original, false);
    }

    @Override
    public Boolean delete(long id) {
        try{
            personaDAO.delete(this.getEntity(id, false));
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

    @Override
    public Persona init(Persona persona) {
        Portage portage = portageService.getEntity(persona.getPortage().getId(), true);

        List<PersonaCaracteristic> personaCaracteristicList = new ArrayList<>();

        for(CaracteristicModified c : portage.getCaracteristicList()){

            PersonaCaracteristic p = new PersonaCaracteristic();

            p.setCaracteristicModified(c);
            p.setPersona(persona);
            p.setValue("null");

            long id = personaCaracteristicService.create(personaCaracteristicFactory.toJson(p));
            personaCaracteristicList.add(personaCaracteristicService.getEntity(id));
        }

        persona = personaDAO.update(persona);

        return persona;
    }
}
