package PersonaManager.Service;

import PersonaManager.DAO.Interface.IHumanDAO;
import PersonaManager.Factory.Interface.IHumanFactory;
import PersonaManager.Model.Human;
import PersonaManager.Service.Interface.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanService implements IHumanService {

    public HumanService() {}

    @Autowired
    private IHumanFactory humanFactory;
    @Autowired
    private IHumanDAO humanDAO;

    @Override
    public Long create(String entityAsString) {
        Human human = humanDAO.create(humanFactory.fromJson(entityAsString));
        return human.getId();
    }

    @Override
    public String getById(long id, boolean complete) {
        return humanFactory.toJson(
                this.getEntity(id, complete),
                complete
        );
    }

    @Override
    public Boolean update(String entityAsString) {
        try {
            humanDAO.update(humanFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean delete(String entityAsString) {
        try {
            humanDAO.delete(humanFactory.fromJson(entityAsString));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public String getAll() {
        return humanFactory.allToJson(humanDAO.getAll(), false);
    }

    @Override
    public Human getEntity(long id, boolean complete){
        return humanDAO.getById(id, complete);
    }
}
