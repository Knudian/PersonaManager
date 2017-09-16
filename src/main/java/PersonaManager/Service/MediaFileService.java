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
    public JsonValue getById(long id) {
        MediaFile mediaFile = mediaFileDAO.getById(id);
        return mediaFileFactory.toJson(mediaFile);
    }

    @Override
    public Boolean delete(String entityAsString) {
        try{
            MediaFile mediaFile = mediaFileFactory.fromJson(entityAsString);
            mediaFileDAO.delete(mediaFile);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public MediaFile save(MediaFile mediaFile) {
        return mediaFileDAO.create(mediaFile);
    }

    @Override
    public MediaFile getByFileName(String filename) {
        return mediaFileDAO.getByFileName(filename);
    }
}
