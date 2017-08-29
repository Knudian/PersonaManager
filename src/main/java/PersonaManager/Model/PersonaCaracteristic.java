package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persona_caracteristic")
public class PersonaCaracteristic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @OneToOne(targetEntity = CaracteristicModified.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "caracteristic_modifiedId")
    @Getter
    @Setter
    private CaracteristicModified caracteristicModified;

    @OneToOne(targetEntity = Persona.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "personaId")
    @Getter
    @Setter
    private Persona persona;

    @Column(name = "value", nullable = false)
    @Getter
    @Setter
    private String value;

    public PersonaCaracteristic(){}
    
    public String toJson(boolean complete){
        String str = "{";
        str += "'id':" + this.getId() + ",";
        str += "'caracteristicModified':" + this.getCaracteristicModified().toJson(complete)+ ",";
        str += "'value':" + this.getValue() + ",";
        if (complete)
            str += "'persona':" + this.getPersona().getId()+ ",";
        str += "}";
        return str;
    }
}
