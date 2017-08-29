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

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<Persona> personaList;
    
    @OneToMany(mappedBy = "gameSystem", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<CaracteristicModified> caracteristicList;
    
    public Portage(){ }
    
    public String getCaracsJson(boolean complete){
        String str = "[";
        for(CaracteristicModified p : this.getCaracteristicList()){
            str += p.toJson(complete);
        }
        str += "]";
        return str;
    }
    public String getPersonaJson(){
        String str = "[";
        for(Persona p : this.getPersonaList()){
            str += p.getId();
        }
        str += "]";
        return str;
    }
    
    public String toJson(boolean complete){
        String str = "{";
        str += "'id':" + this.getId() + ",";
        str += "'creationTime':" + this.getCreationTime().getTime() + ",";
        str += "'gameSystem':'"+ this.getGameSystem().getId()+ "',";
        str += "'universe':'"+ this.getUniverse().getId()+"' },";
        if (complete)
            str += "'caracteristicList':" + this.getCaracsJson(false);
            str += "'persona':" + this.getPersonaJson()+ ",";
        str += "}";
        return str;
    }
}
