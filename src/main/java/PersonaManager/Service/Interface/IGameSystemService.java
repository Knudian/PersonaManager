package PersonaManager.Service.Interface;

import PersonaManager.Model.GameSystem;

public interface IGameSystemService {

    /**
     * Allows to create a GameSystem Entry
     *
     * @param gameSystem GameSystem : the entry to save
     * @return GameSystem : the saved entry
     */
    public GameSystem create(GameSystem gameSystem);

    /**
     * Allows to get a GameSystem Entry by its ID
     *
     * @param id long : the entry's ID
     * @return GameSystem : the entry itself
     */
    public GameSystem getById(long id);

    /**
     * Allows a GameSystem Entry to be updated
     *
     * @param gameSystem GameSystem : the entry to update
     */
    public void update(GameSystem gameSystem);

    /**
     * Allows to delete a GameSystem entry
     *
     * @param gameSystem GameSystem : the entry to delete
     */
    public void delete(GameSystem gameSystem);
}
