package PersonaManager.Service.Interface;

import PersonaManager.Model.Caracteristic;

public interface ICaracteristicService {

    /**
     * Allows to create a Caracteristic Entry
     *
     * @param caracteristic Caracteristic : the entry to save
     * @return Caracteristic : the saved entry
     */
    public Caracteristic create(Caracteristic caracteristic);

    /**
     * Allows to get a Caracteristic Entry by its ID
     *
     * @param id long : the entry's ID
     * @return Caracteristic : the entry itself
     */
    public Caracteristic getById(long id);

    /**
     * Allows a Caracteristic Entry to be updated
     *
     * @param caracteristic Caracteristic : the entry to update
     */
    public void update(Caracteristic caracteristic);

    /**
     * Allows to delete a Caracteristic entry
     *
     * @param caracteristic Caracteristic : the entry to delete
     */
    public void delete(Caracteristic caracteristic);
}
