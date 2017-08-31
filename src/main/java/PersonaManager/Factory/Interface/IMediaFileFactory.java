package PersonaManager.Factory.Interface;

import PersonaManager.Model.MediaFile;

public interface IMediaFileFactory {

    public String toJson(MediaFile mediaFile);

    public MediaFile fromJson(String inputDatas);
}
