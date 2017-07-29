package PersonaManager.DAO.Interface;

import PersonaManager.Model.Human;

public interface IHumanDAO {

    public Human create(Human human);

    public Human getById(long id, boolean lazy);

    public void update(Human human);

    public void delete(Human human);
}
