package PersonaManager.Service.Interface;

import PersonaManager.Model.PersonaType;

public interface IPersonaTypeService {

    /**
     * Allows to create a PersonaType Entry
     *
     * @param personaType PersonaType : the entry to save
     * @return PersonaType : the saved entry
     */
    public PersonaType create(PersonaType personaType);

    /**
     * Allows to get a PersonaType Entry by its ID
     *
     * @param id long : the entry's ID
     * @return PersonaType : the entry itself
     */
    public PersonaType getById(long id);

    /**
     * Allows a PersonaType Entry to be updated
     *
     * @param personaType PersonaType : the entry to update
     */
    public void update(PersonaType personaType);

    /**
     * Allows to delete a PersonaType entry
     *
     * @param personaType PersonaType : the entry to delete
     */
    public void delete(PersonaType personaType);
}
