package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPortageDAO;
import PersonaManager.Model.Portage;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PortageService implements IPortageService {

    @Autowired
    private IPortageDAO portageDAO;

    @Override
    /**
     * @InheritDoc
     */
    public Portage create(Portage portage) {
        return portageDAO.create(portage);
    }

    @Override
    /**
     * @InheritDoc
     */
    public Portage getById(long id) {
        return portageDAO.getById(id);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void update(Portage portage) {
        portageDAO.update(portage);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(Portage portage) {
        portageDAO.delete(portage);
    }
}
