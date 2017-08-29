package PersonaManager.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Serializable objectId;

    public AbstractDAO(){
    }

}
