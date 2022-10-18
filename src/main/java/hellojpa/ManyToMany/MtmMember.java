package hellojpa.ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class MtmMember {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String userName;

    @OneToMany(mappedBy = "member")
    private List<MtmMemberProduct> memberProducts;
}
