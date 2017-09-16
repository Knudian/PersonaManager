package PersonaManager.Service.Interface;

import PersonaManager.Model.MediaFile;

import javax.json.JsonValue;

public interface IMediaFileService {

    public Long create(String entityAsString);

    public JsonValue getById(long id);

    public Boolean delete(String entityAsString);

    public MediaFile save(MediaFile mediaFile);

    public MediaFile getByFileName(String filename);
}
