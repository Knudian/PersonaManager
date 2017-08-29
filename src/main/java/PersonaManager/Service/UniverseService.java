package PersonaManager.Service;

import PersonaManager.DAO.Interface.IUniverseDAO;
import PersonaManager.Model.Universe;
import PersonaManager.Service.Interface.IUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UniverseService implements IUniverseService {

    @Autowired
    private IUniverseDAO universeDAO;

    @Override
    /**
     * @InheritDoc
     */
    public Universe create(Universe universe) {
        return universeDAO.create(universe);
    }

    @Override
    /**
     * @InheritDoc
     */
    public Universe getById(long id, boolean lazy) {
        return universeDAO.getById(id, lazy);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(Universe universe) {
        universeDAO.update(universe);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(Universe universe) {
        universeDAO.delete(universe);
    }

    @Override
    public List<Universe> getAll() {

        return universeDAO.getAll(true);
    }
}
