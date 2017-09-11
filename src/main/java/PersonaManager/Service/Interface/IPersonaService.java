package PersonaManager.Service.Interface;

import PersonaManager.Model.Persona;

import java.util.List;

public interface IPersonaService {

    public Long create(String entityAsString);

    public String getById(long id, boolean complete);

    public String update(String entityAsString, long id);

    public Boolean delete(long id);

    public String getLastPublicPersonnas(Integer quantity);

    public String getAll();

    public Persona getEntity(long id, boolean complete);

    public Persona init(Persona persona);
}
