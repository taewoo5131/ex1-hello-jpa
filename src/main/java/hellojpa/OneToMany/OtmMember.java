package hellojpa.OneToMany;

import javax.persistence.*;

@Entity
public class OtmMember {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID" , insertable = false , updatable = false)
    private OtmTeam team;
}
