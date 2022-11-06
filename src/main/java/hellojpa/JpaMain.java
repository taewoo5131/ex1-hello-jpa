package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Food food = new Food();
            food.setName("스테이크");
            food.setPersonInfo((new PersonInfo("고든램지" , "아일랜드" , "MALE")));
            food.setPeriod(new Period(LocalDateTime.now() , LocalDateTime.now().plusDays(2L)));
            food.setGuestInfo(new PersonInfo("손님1" , "한국" , "FEMALE"));
            em.persist(food);

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
