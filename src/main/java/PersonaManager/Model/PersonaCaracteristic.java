package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "persona_caracteristic",
        uniqueConstraints = @UniqueConstraint(columnNames = {"caracteristic_modifiedId", "personaId"})
)
public class PersonaCaracteristic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @OneToOne(targetEntity = CaracteristicModified.class, fetch = FetchType.EAGER,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaCaracteristic that = (PersonaCaracteristic) o;

        if (!caracteristicModified.equals(that.caracteristicModified)) return false;
        if (!persona.equals(that.persona)) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }
}
