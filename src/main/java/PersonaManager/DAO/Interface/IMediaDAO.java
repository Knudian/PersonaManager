package PersonaManager.DAO.Interface;

import PersonaManager.Model.Media;

public interface IMediaDAO {

    public Media create(Media media);

    public Media getById(long id);

    public void delete(Media media);
}
