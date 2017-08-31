package PersonaManager.Model;

import java.util.*;

public class ApiResponse {

    private List<String> response;

    private List<String> errors;

    private Date requestDate;

    public ApiResponse(){
        this.response = new ArrayList<String>();
        this.errors   = new ArrayList<String>();
        this.requestDate = new Date();
    }

    public void addContent(String content){
        this.response.add(content);
    }

    public void addError(String error){
        this.errors.add(error);
    }

    public String toString(){
        // TODO : Transform this method using the Javax.Json
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{'requestTime':")
                .append(this.requestDate.getTime())
                .append(",")
                .append("'response':[");
        for(int i = 0; i < this.response.size(); i++){
            stringBuilder.append(this.response.get(i));
            if( i < (this.response.size() -1)){
                stringBuilder.append(',');
            }
        }
        stringBuilder.append("],")
                .append("'errors':[");
        for(int i = 0; i < this.errors.size(); i++){
            stringBuilder.append(this.errors.get(i));
            if( i < (this.errors.size() -1)){
                stringBuilder.append(',');
            }
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
