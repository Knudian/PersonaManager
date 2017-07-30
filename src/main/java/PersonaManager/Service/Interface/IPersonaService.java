package PersonaManager.Service.Interface;

import PersonaManager.Model.Persona;

public interface IPersonaService {

    /**
     * Allows to create a Persona Entry
     *
     * @param persona Persona : the entry to save
     * @return Persona : the saved entry
     */
    public Persona create(Persona persona);

    /**
     * Allows to get a Persona Entry by its ID
     *
     * @param id long : the entry's ID
     * @param lazy boolean : has the entry to be eagerly loaded?
     * @return Persona : the entry itself
     */
    public Persona getById(long id, boolean lazy);

    /**
     * Allows a Persona Entry to be updated
     *
     * @param persona Persona : the entry to update
     */
    public void update(Persona persona);

    /**
     * Allows to delete a Persona entry
     *
     * @param persona Persona : the entry to delete
     */
    public void delete(Persona persona);
}
