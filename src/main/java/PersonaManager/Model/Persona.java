package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @OneToOne(targetEntity = Universe.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @PrimaryKeyJoinColumn
    @Getter
    @Setter
    private Universe universe;

    @ManyToOne(targetEntity = Human.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanId", nullable = false)
    @Getter
    @Setter
    private Human owner;

    @Column(name = "isPublic", nullable = false)
    @Getter
    @Setter
    private boolean isPublic = false;

    @Column(name = "first_name", nullable = false)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Getter
    @Setter
    private String lastname;

    @Column(name = "creation_time", nullable = false)
    @Getter
    @Setter
    private Timestamp creationTime;

    @Column(name = "last_update", nullable = false)
    @Getter
    @Setter
    private Timestamp lastUpdate;

    @OneToOne(targetEntity = Media.class,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "mediaId")
    @Getter
    @Setter
    private Media image;

    @Column(name = "gender", nullable = false)
    @Getter
    @Setter
    private EnumPersonaGender gender;

    @OneToOne(targetEntity = PersonaType.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "persona_typeId")
    @Getter
    @Setter
    private PersonaType type;

    @OneToMany(targetEntity = PersonaCaracteristic.class, fetch = FetchType.LAZY, mappedBy = "persona",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<PersonaCaracteristic> caracteristicList;

    public Persona() {}

}
