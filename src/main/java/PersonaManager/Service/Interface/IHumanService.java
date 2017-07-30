package PersonaManager.Service.Interface;

import PersonaManager.Model.Human;

public interface IHumanService {

    /**
     * Allows to create a Human Entry
     *
     * @param human Human : the entry to save
     * @return Human : the saved entry
     */
    public Human create(Human human);

    /**
     * Allows to get a Human Entry by its ID
     *
     * @param id long : the entry's ID
     * @param lazy boolean : has the entry to be eagerly loaded or not.
     * @return Human : the entry itself
     */
    public Human getById(long id, boolean lazy);

    /**
     * Allows a Human Entry to be updated
     *
     * @param human Human : the entry to update
     */
    public void update(Human human);

    /**
     * Allows to delete a Human entry
     *
     * @param human Human : the entry to delete
     */
    public void delete(Human human);
}
