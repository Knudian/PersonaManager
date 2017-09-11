package PersonaManager.Factory;

import javax.json.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class BaseFactory {

    protected String write(JsonObject model){
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(model);
        jsonWriter.close();

        return stringWriter.toString();
    }

    protected JsonObject getStructure(String json){
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = reader.readObject();
        reader.close();
        return jsonObject;
    }
}
