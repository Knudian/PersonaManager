package PersonaManager.DAO.Interface;

import PersonaManager.Model.Persona;

public interface IPersonaDAO {

    public Persona create(Persona persona);

    public Persona getById(long id, boolean lazy);

    public void update(Persona persona);

    public void delete(Persona persona);
}
