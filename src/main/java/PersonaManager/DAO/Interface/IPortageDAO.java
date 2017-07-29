package PersonaManager.DAO.Interface;

import PersonaManager.Model.Portage;

public interface IPortageDAO {

    public Portage create(Portage portage);

    public Portage getById(long id);

    public void delete(Portage portage);

    public void update(Portage portage);
}
