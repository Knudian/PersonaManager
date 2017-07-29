package PersonaManager.DAO.Interface;

import PersonaManager.Model.GameSystem;

public interface IGameSystemDAO {

    public GameSystem create(GameSystem gameSystem);

    public GameSystem getById(long id);

    public void delete(GameSystem gameSystem);

    public void update(GameSystem gameSystem);
}
