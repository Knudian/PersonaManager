package PersonaManager.Service.Interface;

import PersonaManager.Model.PersonaCaracteristic;

public interface IPersonaCaracteristicService {

    /**
     * Allows to create a PersonaCaracteristic Entry
     *
     * @param personaCaracteristic PersonaCaracteristic : the entry to save
     * @return PersonaCaracteristic : the saved entry
     */
    public PersonaCaracteristic create(PersonaCaracteristic personaCaracteristic);

    /**
     * Allows to get a PersonaCaracteristic Entry by its ID
     *
     * @param id long : the entry's ID
     * @return PersonaCaracteristic : the entry itself
     */
    public PersonaCaracteristic getById(long id);

    /**
     * Allows a PersonaCaracteristic Entry to be updated
     *
     * @param personaCaracteristic PersonaCaracteristic : the entry to update
     */
    public void update(PersonaCaracteristic personaCaracteristic);

    /**
     * Allows to delete a PersonaCaracteristic entry
     *
     * @param personaCaracteristic PersonaCaracteristic : the entry to delete
     */
    public void delete(PersonaCaracteristic personaCaracteristic);
}
