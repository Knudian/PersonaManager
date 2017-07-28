package PersonaManager.Model;

public enum EnumPersonaGender {

    MALE("male"),
    FEMALE("female"),
    TRANSGENDER("transgender"),
    UNDEFINED("undefined"),
    OTHER("other");

    private String key;

    EnumPersonaGender(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }

    public String toString(){
        return this.key;
    }

}
