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

    @ManyToOne(targetEntity = GameSystem.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "game_systemId", nullable = false)
    @Getter
    @Setter
    private GameSystem gameSystem;

    @ManyToOne(targetEntity = Universe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "universeId", nullable = false)
    @Getter
    @Setter
    private Universe universe;

    @Column(name = "creation_time", nullable = false)
    @Getter
    @Setter
    private Timestamp creationTime;

    public Portage(){ }
}
