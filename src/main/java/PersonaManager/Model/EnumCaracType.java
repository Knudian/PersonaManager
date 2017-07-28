package PersonaManager.Model;

public enum EnumCaracType {

    STRING("string"),
    INTEGER("integer"),
    BOOLEAN("boolean");

    private String key;

    EnumCaracType(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

    public String toString(){
        return this.key;
    }
}
