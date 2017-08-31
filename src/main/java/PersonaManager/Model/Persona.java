package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne(targetEntity = Human.class, fetch = FetchType.EAGER)
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

    @OneToOne(targetEntity = MediaFile.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "mediaId")
    @Getter
    @Setter
    private MediaFile image;

    @Column(name = "gender", nullable = false)
    @Getter
    @Setter
    private EnumPersonaGender gender;

    @OneToOne(targetEntity = PersonaType.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "persona_typeId")
    @Getter
    @Setter
    private PersonaType personaType;

    @OneToMany(targetEntity = PersonaCaracteristic.class, fetch = FetchType.LAZY, mappedBy = "persona",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<PersonaCaracteristic> caracteristicList;

    @OneToOne(targetEntity = Portage.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "portageId")
    @Getter
    @Setter
    private Portage portage;

    @Getter
    @Setter
    @Column(length = 140)
    private String description = "";

    public Persona() {}

}
