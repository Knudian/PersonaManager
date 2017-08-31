package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "portage")
public class Portage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @ManyToOne(targetEntity = GameSystem.class)
    @JoinColumn(name = "game_systemId", nullable = false)
    @Getter
    @Setter
    private GameSystem gameSystem;

    @ManyToOne(targetEntity = Universe.class)
    @JoinColumn(name = "universeId", nullable = false)
    @Getter
    @Setter
    private Universe universe;

    @Column(name = "creation_time", nullable = false)
    @Getter
    @Setter
    private Timestamp creationTime;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "portage",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<Persona> personaList;
    
    @OneToMany(mappedBy = "portage", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<CaracteristicModified> caracteristicList;
    
    public Portage(){ }
}
