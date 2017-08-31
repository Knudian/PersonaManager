package PersonaManager.Service;

import PersonaManager.DAO.Interface.IPortageDAO;
import PersonaManager.Factory.Interface.IPortageFactory;
import PersonaManager.Model.Portage;
import PersonaManager.Service.Interface.IPortageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortageService implements IPortageService {

    public PortageService() {}

    @Autowired
    private IPortageDAO portageDAO;

    @Autowired
    private IPortageFactory portageFactory;

    @Override
    public Long create(String entityAsString) {
        Portage portage = portageFactory.fromJson(entityAsString);
        portage = portageDAO.create(portage);
        return portage.getId();
    }

    @Override
    public String getById(long id, boolean complete) {
        return portageFactory.toJson(this.getEntity(id, complete), complete);
    }

    @Override
    public Boolean update(String entityAsString) {
        try {
            Portage portage = portageFactory.fromJson(entityAsString);
            portageDAO.update(portage);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            Portage portage = portageFactory.fromJson(entityAsString);
            portageDAO.delete(portage);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public String getAll(boolean complete) {
        List<Portage> portageList = portageDAO.getAll(complete);
        return portageFactory.allToJson(portageList, complete);
    }

    @Override
    public Portage getEntity(long id, boolean complete) {
        return portageDAO.getById(id, complete);
    }
}
