package PersonaManager.DAO.Interface;

import PersonaManager.Model.PersonaType;

public interface IPersonaTypeDAO {

    public PersonaType create(PersonaType personaType);

    public PersonaType getById(long id);

    public PersonaType update(PersonaType personaType);

    public void delete(PersonaType personaType);
}
