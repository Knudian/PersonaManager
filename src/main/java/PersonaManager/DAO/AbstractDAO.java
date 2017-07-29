package PersonaManager.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Serializable objectId;

    protected Session currentSession;

    public AbstractDAO(){
        this.currentSession = sessionFactory.getCurrentSession();
    }

}
