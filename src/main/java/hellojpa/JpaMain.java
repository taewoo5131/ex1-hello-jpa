package hellojpa;

import hellojpa.OneToOne.Locker;
import hellojpa.OneToOne.Student;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Child child1 = new Child();
            child1.setName("신짱구");
            Child child2 = new Child();
            child2.setName("신짱아");
            Child child3 = new Child();
            child3.setName("훈발놈");

            Parent parent = new Parent();
            parent.setName("신형만");
            parent.addChild(child1);
            parent.addChild(child2);
            parent.addChild(child3); // 훈발놈을 잠시 거둬주신 신형만씨

            em.persist(parent);
            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildren().remove(2);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
