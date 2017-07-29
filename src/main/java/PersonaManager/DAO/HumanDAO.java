package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IHumanDAO;
import PersonaManager.Model.Human;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

@Repository
public class HumanDAO extends AbstractDAO implements IHumanDAO {

    public HumanDAO(){
        super();
    }

    @Override
    public Human create(Human human) {
        this.currentSession.save(human);
        this.currentSession.refresh(human);
        return human;
    }

    @Override
    public Human getById(long id, boolean lazy) {
        Human human = this.currentSession.get(Human.class, id);
        if( lazy ){
            Hibernate.initialize(human.getPersonaList());
        }
        return human;
    }

    @Override
    public void update(Human human) {
        this.currentSession.update(human);
        this.currentSession.refresh(human);
    }

    @Override
    public void delete(Human human) {
        this.currentSession.remove(human);
    }
}
