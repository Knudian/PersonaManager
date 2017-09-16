package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Model.MediaFile;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

@Service
public class MediaFileFactory extends BaseFactory implements IMediaFileFactory {

    public MediaFileFactory() {
        super();
    }

    @Override
    public JsonValue toJson(MediaFile mediaFile) {
        if ( mediaFile != null){
            JsonObject model = Json.createObjectBuilder()
                    .add("id", mediaFile.getId())
                    .add("name", mediaFile.getFilename())
                    .add("uploaded", mediaFile.getUploadTime().getTime())
                    .build();
            return model;
        } else {
            return JsonValue.NULL;
        }
    }

    @Override
    public MediaFile fromJson(String inputDatas) {
        JsonObject model = this.getStructure(inputDatas);
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFilename(model.getString("name"));
        return mediaFile;
    }
}
