package hellojpa.OneToOne;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private Long id;

    @Column(name = "STUDENT_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID" , unique = true)
    private Locker locker;
}
