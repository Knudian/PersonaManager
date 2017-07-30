package PersonaManager.Service;

import PersonaManager.DAO.HumanDAO;
import PersonaManager.Model.Human;
import PersonaManager.Service.Interface.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HumanService implements IHumanService {

    @Autowired
    private HumanDAO humanDAO;

    @Override
    /**
     * @InheritDoc
     */
    public Human create(Human human) {
        return humanDAO.create(human);
    }

    @Override
    /**
     * @InheritDoc
     */
    public Human getById(long id, boolean lazy) {
        return humanDAO.getById(id, lazy);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(Human human) {
        humanDAO.update(human);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(Human human) {
        humanDAO.delete(human);
    }
}