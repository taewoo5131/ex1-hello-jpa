package hellojpa.ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class MtmProduct {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @OneToMany(mappedBy = "product")
    private List<MtmMemberProduct> memberProducts;
}
