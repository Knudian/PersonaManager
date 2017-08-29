package PersonaManager.Service;

import PersonaManager.DAO.Interface.IGameSystemDAO;
import PersonaManager.Model.GameSystem;
import PersonaManager.Service.Interface.IGameSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameSystemService implements IGameSystemService {

    @Autowired
    private IGameSystemDAO gameSystemDAO;

    @Override
    /**
     * @InheritDoc
     */
    public GameSystem create(GameSystem gameSystem) {
        return gameSystemDAO.create(gameSystem);
    }

    @Override
    /**
     * @InheritDoc
     */
    public GameSystem getById(long id, boolean lazy) {
        return gameSystemDAO.getById(id, lazy);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(GameSystem gameSystem) {
        gameSystemDAO.update(gameSystem);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(GameSystem gameSystem) {
        gameSystemDAO.delete(gameSystem);
    }

    @Override
    public List<GameSystem> getAll() {
        return gameSystemDAO.getAll(true);
    }
}
