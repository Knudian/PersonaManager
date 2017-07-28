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

    @ManyToOne(targetEntity = Universe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "universeId", nullable = false)
    @Getter
    @Setter
    private Universe universe;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    public PersonaType(){}

}
