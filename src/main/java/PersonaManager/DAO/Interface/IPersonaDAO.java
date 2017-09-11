package PersonaManager.DAO.Interface;

import PersonaManager.Model.Persona;

import java.util.List;

public interface IPersonaDAO {

    public Persona create(Persona persona);

    public Persona getById(long id, boolean complete);

    public Persona update(Persona persona);

    public void delete(Persona persona);

    public List<Persona> getLastPublicPersona(Integer limit);

    public List<Persona> getAll();
}
