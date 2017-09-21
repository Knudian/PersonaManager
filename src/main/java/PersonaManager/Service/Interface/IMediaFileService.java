package PersonaManager.Service.Interface;

import PersonaManager.Model.MediaFile;

import javax.json.JsonValue;

public interface IMediaFileService extends IStandardService {
    public MediaFile getByFileName(String filename);

    public MediaFile getEntity(long id);
}
