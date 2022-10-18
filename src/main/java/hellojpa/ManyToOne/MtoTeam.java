package hellojpa.ManyToOne;

import javax.persistence.*;
import java.util.List;

@Entity
public class MtoTeam {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "TEAM_NAME")
    private String name;

    @OneToMany(mappedBy = "mtoTeam")
    private List<MtoMember> mtoMembers;
}
