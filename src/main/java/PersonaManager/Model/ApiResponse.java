package PersonaManager.Model;

import javax.json.*;
import java.io.StringWriter;
import java.util.*;

public class ApiResponse {

    private List<String> response;

    private List<String> errors;

    private Date requestDate;

    public ApiResponse(){
        this.response = new ArrayList<>();
        this.errors   = new ArrayList<>();
        this.requestDate = new Date();
    }

    public void addContent(String content){
        this.response.add(content);
    }

    public void addError(String error){
        this.errors.add(error);
    }

    public String toString(){
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("requestTime", this.requestDate.getTime())
                .add("response", this.listToJson(this.response))
                .add("errors", this.listToJson(this.errors))
                .build();

        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(jsonObject);
        jsonWriter.close();

        return stringWriter.toString();
    }

    private JsonArray listToJson(List<String> list){
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for(String s : list){
            builder.add(Json.createValue(s));
        }
        return builder.build();
    }
}
