package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "caracteristic_modified")
public class CaracteristicModified implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @ManyToOne(targetEntity = Portage.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "portageId", nullable = false)
    @Getter
    @Setter
    private Portage portage;

    @OneToOne(targetEntity = Caracteristic.class, fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "caracteristicId")
    @Getter
    @Setter
    private Caracteristic caracteristic;

    @Column(name = "label", nullable = false)
    @Getter
    @Setter
    private String label;

    public CaracteristicModified() { }
    
    public String toJson(boolean complete){
        String str = "{";
        str += "'id':" + this.getId() + ",";
        str += "'label':" + this.getLabel()+ ",";
        str += "'caracteristic':" + this.getCaracteristic().toJson(complete)+ ",";
        if (complete)
            str += "'portage':" + this.getPortage().getId()+ ",";
        str += "}";
        return str;
    }
}
