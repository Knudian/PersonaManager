package PersonaManager.DAO.Interface;

import PersonaManager.Model.PersonaCaracteristic;

public interface IPersonaCaracteristicDAO {

    public PersonaCaracteristic create(PersonaCaracteristic personaCaracteristic);

    public PersonaCaracteristic getById(long id);

    public void update(PersonaCaracteristic personaCaracteristic);

    public void delete(PersonaCaracteristic personaCaracteristic);
}
