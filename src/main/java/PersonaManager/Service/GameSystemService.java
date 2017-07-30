package PersonaManager.Service;

import PersonaManager.DAO.GameSystemDAO;
import PersonaManager.Model.GameSystem;
import PersonaManager.Service.Interface.IGameSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameSystemService implements IGameSystemService {

    @Autowired
    private GameSystemDAO gameSystemDAO;

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
    public GameSystem getById(long id) {
        return gameSystemDAO.getById(id);
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
}
