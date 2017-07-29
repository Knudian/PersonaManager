package PersonaManager.DAO;

import PersonaManager.DAO.Interface.IMediaFileDAO;
import PersonaManager.Model.MediaFile;
import org.springframework.stereotype.Repository;

@Repository
public class MediaFileDAO extends AbstractDAO implements IMediaFileDAO {

    public MediaFileDAO(){
        super();
    }

    @Override
    public MediaFile create(MediaFile mediaFile) {
        this.currentSession.save(mediaFile);
        this.currentSession.refresh(mediaFile);
        return mediaFile;
    }

    @Override
    public MediaFile getById(long id) {
        return this.currentSession.get(MediaFile.class, id);
    }

    @Override
    public void delete(MediaFile mediaFile) {
        this.currentSession.remove(mediaFile);
    }
}
