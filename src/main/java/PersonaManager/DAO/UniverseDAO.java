package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IUniverseDAO;
import PersonaManager.Model.Universe;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

@Repository
public class UniverseDAO extends AbstractDAO implements IUniverseDAO {

    public UniverseDAO(){
        super();
    }

    @Override
    public Universe create(Universe universe) {
        this.currentSession.save(universe);
        this.currentSession.refresh(universe);
        return universe;
    }

    @Override
    public Universe getById(long id, boolean lazy) {
        Universe universe = this.currentSession.get(Universe.class, id);
        if( lazy ){
            Hibernate.initialize(universe.getPersonaTypeList());
        }
        return universe;
    }

    @Override
    public void update(Universe universe) {
        this.currentSession.update(universe);
        this.currentSession.refresh(universe);
    }

    @Override
    public void delete(Universe universe) {
        this.currentSession.remove(universe);
    }
}
