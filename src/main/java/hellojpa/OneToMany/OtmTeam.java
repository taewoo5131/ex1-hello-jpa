package hellojpa.OneToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class OtmTeam {
    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "TEAM_NAME")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<OtmMember> otmMembers;
}
