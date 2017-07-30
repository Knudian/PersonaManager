package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IMediaFileDAO;
import PersonaManager.Model.MediaFile;
import org.springframework.stereotype.Repository;

@Repository
public class MediaFileDAO extends AbstractDAO implements IMediaFileDAO {



    @Override
    public MediaFile create(MediaFile mediaFile) {
        objectId = sessionFactory.getCurrentSession().save(mediaFile);
        sessionFactory.getCurrentSession().refresh(mediaFile);
        return mediaFile;
    }

    @Override
    public MediaFile getById(long id) {
        return sessionFactory.getCurrentSession().get(MediaFile.class, id);
    }

    @Override
    public void delete(MediaFile mediaFile) {
        sessionFactory.getCurrentSession().remove(mediaFile);
    }
}
