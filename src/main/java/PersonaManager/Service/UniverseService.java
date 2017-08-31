package PersonaManager.Service;

import PersonaManager.DAO.Interface.IUniverseDAO;
import PersonaManager.Factory.Interface.IUniverseFactory;
import PersonaManager.Model.Universe;
import PersonaManager.Service.Interface.IUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniverseService implements IUniverseService {

    public UniverseService() {}

    @Autowired
    private IUniverseDAO universeDAO;

    @Autowired
    private IUniverseFactory universeFactory;

    @Override
    public Long create(String entityAsString) {
        Universe universe = universeFactory.fromJson(entityAsString);
        universe = universeDAO.create(universe);
        return universe.getId();
    }

    @Override
    public String getById(long id, boolean complete) {
        return universeFactory.toJson(this.getEntity(id, complete), complete);
    }

    @Override
    public Boolean update(String entityAsString) {
        try {
            Universe universe = universeFactory.fromJson(entityAsString);
            universeDAO.update(universe);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            Universe universe = universeFactory.fromJson(entityAsString);
            universeDAO.delete(universe);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public String getAll(boolean complete) {
        return universeFactory.allToJson(universeDAO.getAll(complete), complete);
    }

    @Override
    public Universe getEntity(long id, boolean complete) {
        return universeDAO.getById(id, complete);
    }
}
