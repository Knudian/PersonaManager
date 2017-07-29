package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPortageDAO;
import PersonaManager.Model.Portage;
import org.springframework.stereotype.Repository;

@Repository
public class PortageDAO extends AbstractDAO implements IPortageDAO {

    public PortageDAO(){
        super();
    }

    @Override
    public Portage create(Portage portage) {
        this.currentSession.save(portage);
        this.currentSession.refresh(portage);
        return portage;
    }

    @Override
    public Portage getById(long id) {
        return this.currentSession.get(Portage.class, id);
    }

    @Override
    public void delete(Portage portage) {
        this.currentSession.remove(portage);

    }

    @Override
    public void update(Portage portage) {
        this.currentSession.update(portage);
        this.currentSession.refresh(portage);
    }
}
