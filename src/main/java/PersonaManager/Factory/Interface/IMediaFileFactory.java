package PersonaManager.Factory.Interface;

import PersonaManager.Model.MediaFile;

import javax.json.JsonValue;

public interface IMediaFileFactory {

    public JsonValue toJson(MediaFile mediaFile);

    public MediaFile fromJson(String inputDatas);
}
