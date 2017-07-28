package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "media")
public class Media  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "filename", nullable = false)
    @Getter
    @Setter
    private String filename;

    @Column(name = "uploadTime", nullable = false)
    @Getter
    @Setter
    private Timestamp uploadTime;

    public Media() {}
}
