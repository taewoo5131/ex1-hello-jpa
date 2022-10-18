package hellojpa.ManyToOne;

import javax.persistence.*;

@Entity
public class MtoMember {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private MtoTeam mtoTeam;
}
