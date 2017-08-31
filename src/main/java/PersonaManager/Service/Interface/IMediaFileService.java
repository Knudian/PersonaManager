package PersonaManager.Service.Interface;

import PersonaManager.Model.MediaFile;

public interface IMediaFileService {

    public Long create(String entityAsString);

    public String getById(long id);

    public Boolean delete(String entityAsString);

    public MediaFile save(MediaFile mediaFile);
}
