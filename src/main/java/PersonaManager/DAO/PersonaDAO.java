package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IPersonaDAO;
import PersonaManager.Model.Persona;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDAO extends AbstractDAO implements IPersonaDAO {

    public PersonaDAO(){
        super();
    }

    @Override
    public Persona create(Persona persona) {
        this.currentSession.save(persona);
        this.currentSession.refresh(persona);
        return persona;
    }

    @Override
    public Persona getById(long id, boolean lazy) {
        Persona persona = this.currentSession.get(Persona.class, id);
        if( lazy ){
            Hibernate.initialize(persona.getCaracteristicList());
        }
        return persona;
    }

    @Override
    public void update(Persona persona) {
        this.currentSession.update(persona);
        this.currentSession.refresh(persona);
    }

    @Override
    public void delete(Persona persona) {
        this.currentSession.remove(persona);
    }
}
