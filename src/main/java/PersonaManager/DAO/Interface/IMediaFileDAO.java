package PersonaManager.DAO.Interface;

import PersonaManager.Model.MediaFile;

public interface IMediaFileDAO {

    public MediaFile create(MediaFile mediaFile);

    public MediaFile getById(long id);

    public void delete(MediaFile mediaFile);
}
