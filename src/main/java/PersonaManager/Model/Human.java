package PersonaManager.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "human")
public class Human implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter
    @Setter
    private long id;

    @Column(name = "nick", unique = true, nullable = false)
    @Getter
    @Setter
    private String nick;

    @Column(name = "email", unique = true, nullable = false)
    @Getter
    @Setter
    private String email;


    @Column(name = "salt")
    @Getter
    @Setter
    private String salt;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner",
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @Getter
    @Setter
    private List<Persona> personaList;

    @Column(name = "creationTime")
    @Getter
    @Setter
    private Timestamp creationTime;

    @Column(name = "lastConnection")
    @Getter
    @Setter
    private Timestamp lastConnection;

    @Column(name = "roleList")
    @Getter
    @Setter
    private String roleListStored;

    public Human() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (nick != null ? !nick.equals(human.nick) : human.nick != null) return false;
        if (email != null ? !email.equals(human.email) : human.email != null) return false;
        return password != null ? password.equals(human.password) : human.password == null;
    }
}
