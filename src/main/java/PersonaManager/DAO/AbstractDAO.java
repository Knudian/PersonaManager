package PersonaManager.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional
public abstract class AbstractDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Serializable objectId;

    public AbstractDAO(){}
}
