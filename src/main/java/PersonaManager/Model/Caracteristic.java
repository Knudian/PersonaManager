package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "caracteristic")
public class Caracteristic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_systemId", nullable = false)
    @Getter
    @Setter
    private GameSystem gameSystem;

    @Column(name = "type", nullable = false)
    @Getter
    @Setter
    private EnumCaracType type = EnumCaracType.STRING;

    @Getter
    @Setter
    private String defaultLabel;

    @Getter
    @Setter
    private String minimum;

    @Getter
    @Setter
    private String maximum;

    public Caracteristic() { }
    
    public String toJson(boolean complete){
        String str = "{";
        str += "'id':" + this.getId() + ",";
        str += "'type':" + this.getType()+ ",";
        str += "'defaultLabel':" + this.getDefaultLabel()+ ",";
        str += "'value' : { 'min':'"+ this.getMinimum() + "', 'max':'"+ this.getMaximum()+"'},";
        if (complete)
            str += "'gameSystem':" + this.getGameSystem()+ ",";
        str += "}";
        return str;
    }
}
