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

    @Transient
    private List<String> roleList;

    public Human() {}

    public Human(String nick,
                 String email,
                 String salt,
                 String password,
                 List<Persona> personaList,
                 String roleListStored){
        this.nick           = nick;
        this.email          = email;
        this.salt           = salt;
        this.password       = password;
        this.personaList    = personaList;
        this.roleListStored = roleListStored;
    }
    
    public String getPersonaJson(boolean complete){
        String str = "[";
        for(Persona p : this.getPersonaList()){
            str += p.toJson(complete);
        }
        str += "]";
        return str;
    }
    
    public String toJson(boolean complete){
        String str = "{";
        str += "'id':" + this.getId() + ",";
        str += "'nick':" + this.getNick()+ ",";
        str += "'lastConnection':" + this.getLastConnection().getTime()+ ",";
        if (complete)
            str += "'persona':" + this.getId() + ",";
        str += "}";
        return str;
    }
    
}
