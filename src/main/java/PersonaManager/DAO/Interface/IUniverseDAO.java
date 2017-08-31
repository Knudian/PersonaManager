package PersonaManager.DAO.Interface;

import PersonaManager.Model.Universe;

import java.util.List;

public interface IUniverseDAO {

    public Universe create(Universe universe);

    public Universe getById(long id, boolean complete);

    public void update(Universe universe);

    public void delete(Universe universe);

    public List<Universe> getAll(boolean lazy);
}
