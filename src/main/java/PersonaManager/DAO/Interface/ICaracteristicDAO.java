package PersonaManager.DAO.Interface;

import PersonaManager.Model.Caracteristic;

public interface ICaracteristicDAO {

    public Caracteristic create(Caracteristic caracteristic);

    public Caracteristic getById(long id);

    public void delete(Caracteristic caracteristic);

    public Caracteristic update(Caracteristic caracteristic);
}
