package PersonaManager.Service.Interface;

import PersonaManager.Model.Universe;

public interface IUniverseService {

    /**
     * Allows to create a Universe Entry
     *
     * @param universe Universe : the entry to save
     * @return Universe : the saved entry
     */
    public Universe create(Universe universe);

    /**
     * Allows to get a Universe Entry by its ID
     *
     * @param id long : the entry's ID
     * @param lazy boolean : has the entry to be eagerly loaded?
     * @return Universe : the entry itself
     */
    public Universe getById(long id, boolean lazy);

    /**
     * Allows a Universe Entry to be updated
     *
     * @param universe Universe : the entry to update
     */
    public void update(Universe universe);

    /**
     * Allows to delete a Universe entry
     *
     * @param universe Universe : the entry to delete
     */
    public void delete(Universe universe);
}
