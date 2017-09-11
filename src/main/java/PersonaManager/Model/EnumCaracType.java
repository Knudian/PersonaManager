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

    public static EnumCaracType getType(String key) {

        if (key == null) {
            return null;
        }

        for (EnumCaracType type : EnumCaracType.values()) {
            if (key.equals(type.getKey())) {
                return type;
            }
        }
        throw new IllegalArgumentException("No matching type for key " + key);
    }
}
