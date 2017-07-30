package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaDAO;
import PersonaManager.Model.Persona;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDAO extends AbstractDAO implements IPersonaDAO {



    @Override
    public Persona create(Persona persona) {
        objectId = sessionFactory.getCurrentSession().save(persona);
        sessionFactory.getCurrentSession().refresh(persona);
        return persona;
    }

    @Override
    public Persona getById(long id, boolean lazy) {
        Persona persona = sessionFactory.getCurrentSession().get(Persona.class, id);
        if( lazy ){
            Hibernate.initialize(persona.getCaracteristicList());
        }
        return persona;
    }

    @Override
    public void update(Persona persona) {
        sessionFactory.getCurrentSession().update(persona);
        sessionFactory.getCurrentSession().refresh(persona);
    }

    @Override
    public void delete(Persona persona) {
        sessionFactory.getCurrentSession().remove(persona);
    }
}
