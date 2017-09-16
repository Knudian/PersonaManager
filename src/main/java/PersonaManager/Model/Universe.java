package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "universe")
public class Universe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @OneToOne(targetEntity = MediaFile.class,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "mediaId")
    @Getter
    @Setter
    private MediaFile illustration;

    @Column(name = "name", unique = true, nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(name = "description", nullable = false)
    @Getter
    @Setter
    private String description;

    @Column(name = "creation_time", nullable = false)
    @Getter
    @Setter
    private Timestamp creationTime;
    
    @OneToMany(mappedBy = "universe", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<Portage> portageList;
    
    @OneToMany(targetEntity = PersonaType.class, fetch = FetchType.LAZY, mappedBy = "universe",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<PersonaType> personaTypeList;

    public Universe(){ }
}
