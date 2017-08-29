package PersonaManager.Service.Interface;

import PersonaManager.Model.Portage;

import java.util.List;

public interface IPortageService {

    /**
     * Allows to create a Portage Entry
     *
     * @param portage Portage : the entry to save
     * @return Portage : the saved entry
     */
    public Portage create(Portage portage);

    /**
     * Allows to get a Portage Entry by its ID
     *
     * @param id long : the entry's ID
     * @return Portage : the entry itself
     */
    public Portage getById(long id);

    /**
     * Allows a Portage Entry to be updated
     *
     * @param portage Portage : the entry to update
     */
    public void update(Portage portage);

    /**
     * Allows to delete a Portage entry
     *
     * @param portage Portage : the entry to delete
     */
    public void delete(Portage portage);

    public List<Portage> getAll();
}
