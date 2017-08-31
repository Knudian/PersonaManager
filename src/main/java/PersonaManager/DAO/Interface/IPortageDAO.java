package PersonaManager.DAO.Interface;

import PersonaManager.Model.Portage;

import java.util.List;

public interface IPortageDAO {

    public Portage create(Portage portage);

    public Portage getById(long id, boolean complete);

    public void delete(Portage portage);

    public void update(Portage portage);

    public List<Portage> getAll(boolean complete);
}
