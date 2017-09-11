package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persona_type")
public class PersonaType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @ManyToOne(targetEntity = Universe.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "universeId", nullable = false)
    @Getter
    @Setter
    private Universe universe;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    public PersonaType(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaType that = (PersonaType) o;

        if (universe != null ? !universe.equals(that.universe) : that.universe != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }
}
