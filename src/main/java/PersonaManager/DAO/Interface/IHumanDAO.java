package PersonaManager.DAO.Interface;

import PersonaManager.Model.Human;

import java.util.List;

public interface IHumanDAO {

    public Human create(Human human);

    public Human getById(long id, boolean complete);

    public Human update(Human human);

    public void delete(Human human);

    public List<Human> getAll();
}
