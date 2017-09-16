package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(
        name = "caracteristic_modified",
        uniqueConstraints = @UniqueConstraint(columnNames = {"portageId", "caracteristicId"})
)
public class CaracteristicModified implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @ManyToOne(targetEntity = Portage.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "portageId", nullable = false)
    @Getter
    @Setter
    private Portage portage;

    @OneToOne(targetEntity = Caracteristic.class, fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "caracteristicId")
    @Getter
    @Setter
    private Caracteristic caracteristic;

    @Column(name = "label", nullable = false)
    @Getter
    @Setter
    private String label= "undefined";

    public CaracteristicModified() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaracteristicModified that = (CaracteristicModified) o;

        if (!portage.equals(that.portage)) return false;
        if (!caracteristic.equals(that.caracteristic)) return false;
        return label != null ? label.equals(that.label) : that.label == null;
    }
}
