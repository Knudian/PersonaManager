package PersonaManager.DAO.Interface;

import PersonaManager.Model.GameSystem;

import java.util.List;

public interface IGameSystemDAO {

    public GameSystem create(GameSystem gameSystem);

    public GameSystem getById(long id, boolean complete);

    public void delete(GameSystem gameSystem);

    public GameSystem update(GameSystem gameSystem);

    public List<GameSystem> getAll(boolean lazy);
}
