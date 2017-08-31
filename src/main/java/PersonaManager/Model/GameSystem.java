package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "game_system")
public class GameSystem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "short_name", nullable = false)
    @Getter
    @Setter
    private String shortName;

    @Column(name = "website")
    @Getter
    @Setter
    private String webSite;

    @OneToOne(targetEntity = MediaFile.class,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "mediaId")
    @Getter
    @Setter
    private MediaFile illustration;

    @OneToMany(mappedBy = "gameSystem", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<Caracteristic> caracteristicList;

    @OneToMany(mappedBy = "gameSystem", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<Portage> portageList;
}
