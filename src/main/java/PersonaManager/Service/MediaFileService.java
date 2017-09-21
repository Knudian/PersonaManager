package PersonaManager.Service;

import PersonaManager.DAO.Interface.IMediaFileDAO;
import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Model.MediaFile;
import PersonaManager.Service.Interface.IMediaFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonValue;

@Service
public class MediaFileService implements IMediaFileService {

    public MediaFileService() {}

    @Autowired
    private IMediaFileDAO mediaFileDAO;

    @Autowired
    private IMediaFileFactory mediaFileFactory;

    @Override
    public Long create(String entityAsString) {
        MediaFile mediaFile = mediaFileFactory.fromJson(entityAsString);
        mediaFile = mediaFileDAO.create(mediaFile);
        return mediaFile.getId();
    }

    @Override
    public JsonValue getById(long id, boolean complete) {
        MediaFile mediaFile = mediaFileDAO.getById(id);
        return mediaFileFactory.toJson(mediaFile);
    }

    @Override
    public MediaFile getEntity(long id) {
        return mediaFileDAO.getById(id);
    }

    @Override
    public MediaFile getByFileName(String filename) {
        return mediaFileDAO.getByFileName(filename);
    }

    @Override
    public JsonValue update(String entityAsString, long id) {
        return null;
    }

    @Override
    public Boolean delete(long id) {
        try {
            mediaFileDAO.delete(this.getEntity(id));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public JsonValue patch(long id, String patchingValues) {
        return null;
    }
}
