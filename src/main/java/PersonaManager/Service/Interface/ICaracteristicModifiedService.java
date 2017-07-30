package PersonaManager.Service.Interface;

import PersonaManager.Model.CaracteristicModified;

public interface ICaracteristicModifiedService {

    /**
     * Allows to create a CaracteristicModified Entry
     *
     * @param caracteristicModified CaracteristicModified : the entry to save
     * @return CaracteristicModified : the saved entry
     */
    public CaracteristicModified create(CaracteristicModified caracteristicModified);

    /**
     * Allows to get a CaracteristicModified Entry by its ID
     *
     * @param id long : the entry's ID
     * @return CaracteristicModified : the entry itself
     */
    public CaracteristicModified getById(long id);

    /**
     * Allows a CaracteristicModified Entry to be updated
     *
     * @param caracteristicModified CaracteristicModified : the entry to update
     */
    public void update(CaracteristicModified caracteristicModified);

    /**
     * Allows to delete a CaracteristicModified entry
     *
     * @param caracteristicModified CaracteristicModified : the entry to delete
     */
    public void delete(CaracteristicModified caracteristicModified);
}
