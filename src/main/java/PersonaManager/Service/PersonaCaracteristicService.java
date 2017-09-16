package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPersonaCaracteristicDAO;
import PersonaManager.Factory.Interface.IPersonaCaracteristicFactory;
import PersonaManager.Model.CaracteristicModified;
import PersonaManager.Model.Persona;
import PersonaManager.Model.PersonaCaracteristic;
import PersonaManager.Service.Interface.IPersonaCaracteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonValue;

@Service
public class PersonaCaracteristicService implements IPersonaCaracteristicService {

    public PersonaCaracteristicService() {}

    @Autowired
    private IPersonaCaracteristicDAO personaCaracteristicDAO;

    @Autowired
    private IPersonaCaracteristicFactory personaCaracteristicFactory;

    @Override
    public Long create(String entityAsString) {
        PersonaCaracteristic p = personaCaracteristicFactory.fromJson(entityAsString);
        p = personaCaracteristicDAO.create(p);
        return p.getId();
    }

    @Override
    public JsonValue getById(long id) {
        PersonaCaracteristic personaCaracteristic = personaCaracteristicDAO.getById(id);
        return personaCaracteristicFactory.toJson(personaCaracteristic);
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
        PersonaCaracteristic original = this.getEntity(id);
        PersonaCaracteristic updated  = personaCaracteristicFactory.fromJson(entityAsString);

        if( !updated.equals(original)){
            original.setPersona(updated.getPersona());
            original.setCaracteristicModified(updated.getCaracteristicModified());
            original.setValue(updated.getValue());

            original = personaCaracteristicDAO.update(original);

        }

        return personaCaracteristicFactory.toJson(original);
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            PersonaCaracteristic personaCaracteristic = personaCaracteristicFactory.fromJson(entityAsString);
            personaCaracteristicDAO.delete(personaCaracteristic);
            return true;

        } catch (Exception e){
            return false;
        }
    }

    @Override
    public PersonaCaracteristic getEntity(long id) {
        return personaCaracteristicDAO.getById(id);
    }

    @Override
    public PersonaCaracteristic createStandard(Persona persona, CaracteristicModified caracteristicModified) {
        PersonaCaracteristic p = new PersonaCaracteristic();
        p.setPersona(persona);
        p.setCaracteristicModified(caracteristicModified);
        p.setValue("default");

        return personaCaracteristicDAO.create(p);
    }
}
