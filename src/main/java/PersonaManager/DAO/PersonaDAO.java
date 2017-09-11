package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaDAO;
import PersonaManager.Model.Persona;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class PersonaDAO extends AbstractDAO implements IPersonaDAO {

    public PersonaDAO(){
        super();
    }

    @Override
    public Persona create(Persona persona) {
        persona.setCreationTime(new Timestamp(System.currentTimeMillis()));
        persona.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        objectId = sessionFactory.getCurrentSession().save(persona);
        sessionFactory.getCurrentSession().refresh(persona);
        return persona;
    }

    @Override
    public Persona getById(long id, boolean complete) {
        Persona persona = sessionFactory.getCurrentSession().get(Persona.class, id);
        if( complete ){
            Hibernate.initialize(persona.getCaracteristicList());
        }
        return persona;
    }

    @Override
    public Persona update(Persona persona) {
        persona.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        sessionFactory.getCurrentSession().update(persona);
        sessionFactory.getCurrentSession().flush();
        return persona;
    }

    @Override
    public void delete(Persona persona) {
        sessionFactory.getCurrentSession().remove(persona);
    }

    @Override
    public List<Persona> getLastPublicPersona(Integer limit) {
        String q = "FROM Persona p WHERE p.isPublic = true ORDER BY p.lastUpdate";
        Query query = sessionFactory.getCurrentSession().createQuery(q);
        query.setMaxResults(limit);

        return (List<Persona>) query.getResultList();
    }

    @Override
    public List<Persona> getAll() {
        String q = "SELECT p FROM Persona p";
        Query query = sessionFactory.getCurrentSession().createQuery(q);

        return (List<Persona>) query.getResultList();
    }
}
