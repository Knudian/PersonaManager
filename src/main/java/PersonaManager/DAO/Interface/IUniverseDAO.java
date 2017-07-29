package PersonaManager.DAO.Interface;

import PersonaManager.Model.Universe;

public interface IUniverseDAO {

    public Universe create(Universe universe);

    public Universe getById(long id, boolean lazy);

    public void update(Universe universe);

    public void delete(Universe universe);
}
