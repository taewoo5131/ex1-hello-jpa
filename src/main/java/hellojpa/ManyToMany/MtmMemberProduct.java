package hellojpa.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MtmMemberProduct {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private MtmMember member;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private MtmProduct product;
}
