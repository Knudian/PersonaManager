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
    
    public String getCaracsJson(boolean complete){
        String str = "[";
        for(Caracteristic p : this.getCaracteristicList()){
            str += p.toJson(complete);
        }
        str += "]";
        return str;
    }
    public String getPortageJson(){
        String str = "[";
        for(Portage p : this.getPortageList()){
            str += p.getId();
        }
        str += "]";
        return str;
    }
    public String toJson(boolean complete){
        String str = "{";
        str += "'id':" + this.getId() + ",";
        str += "'webSite':" + this.getWebSite()+ ",";
        str += "'name' : { 'full':'"+ this.getName() + "', 'short':'"+ this.getShortName() +"'},";
        str += "'media':" + (this.getIllustration()!= null ? this.getIllustration().getFilename() : null ) +",";
        if (complete){
            str += "'caracteristicList':" + this.getCaracsJson(false);
            str += "'portageList':" + this.getPortageJson();
        }
        str += "}";
        return str;
    }
}
