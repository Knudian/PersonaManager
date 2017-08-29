package PersonaManager.Service;

import PersonaManager.DAO.Interface.IMediaFileDAO;
import PersonaManager.Model.MediaFile;
import PersonaManager.Service.Interface.IMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaFileService implements IMediaFileService {

    @Autowired
    private IMediaFileDAO mediaFileDAO;

    @Override
    /**
     * @InheritDoc
     */
    public MediaFile create(MediaFile mediaFile) {
        return mediaFileDAO.create(mediaFile);
    }

    @Override
    /**
     * @InheritDoc
     */
    public MediaFile getById(long id) {
        return mediaFileDAO.getById(id);
    }

    @Override
    /**
     * @InheritDoc
     */
    public void delete(MediaFile mediaFile) {
        mediaFileDAO.delete(mediaFile);
    }
}
