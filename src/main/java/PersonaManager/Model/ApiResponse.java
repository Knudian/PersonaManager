package PersonaManager.Model;

import javax.json.*;
import java.io.StringWriter;
import java.util.*;

public class ApiResponse {

    private List<JsonValue> response;

    private List<JsonValue> errors;

    private Date requestDate;

    public ApiResponse(){
        this.response = new ArrayList<>();
        this.errors   = new ArrayList<>();
        this.requestDate = new Date();
    }

    public void addContent(JsonValue content){
        this.response.add(content);
    }

    public void addError(JsonValue error){
        this.errors.add(error);
    }

    public String toString(){
        JsonObject model = Json.createObjectBuilder()
                .add("requestTime", this.requestDate.getTime())
                .add("response", this.listToJson(this.response))
                .add("errors", this.listToJson(this.errors))
                .build();

        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(model);
        jsonWriter.close();

        return stringWriter.toString();
    }

    private JsonArray listToJson(List<JsonValue> list){
        if( list.isEmpty()){
            return JsonValue.EMPTY_JSON_ARRAY;
        }
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(JsonValue s : list){
            builder.add(s);
        }
        return builder.build();
    }
}
