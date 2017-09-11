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

    public static EnumPersonaGender getGender(String key) {

        if (key == null) {
            return null;
        }

        for (EnumPersonaGender gender : EnumPersonaGender.values()) {
            if (key.equals(gender.getKey())) {
                return gender;
            }
        }
        throw new IllegalArgumentException("No matching type for key " + key);
    }
}
