package PersonaManager.Factory;

import PersonaManager.Factory.Interface.IMediaFileFactory;
import PersonaManager.Model.MediaFile;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;

@Service
public class MediaFileFactory extends BaseFactory implements IMediaFileFactory {

    public MediaFileFactory() {
        super();
    }

    @Override
    public String toJson(MediaFile mediaFile) {
        JsonObject model = Json.createObjectBuilder()
                .add("id", mediaFile.getId())
                .add("name", mediaFile.getFilename())
                .add("uploaded", mediaFile.getUploadTime().getTime())
                .build();
        return this.write(model);
    }

    @Override
    public MediaFile fromJson(String inputDatas) {
        JsonObject model = this.getStructure(inputDatas);
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFilename(model.getString("name"));
        return mediaFile;
    }
}
