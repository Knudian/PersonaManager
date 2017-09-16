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

    @Column(name = "name", unique = true, nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "short_name", unique = true, nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameSystem that = (GameSystem) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (webSite != null ? !webSite.equals(that.webSite) : that.webSite != null) return false;
        return illustration != null ? illustration.equals(that.illustration) : that.illustration == null;
    }
}
