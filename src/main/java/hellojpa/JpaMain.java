package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        // 등록
        /*try {
            tx.begin();
            Member member = new Member();
            member.setId(2L);
            member.setName("jihye");
            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }*/

        // 조회
        /*Member member = em.find(Member.class, 1L);
        System.out.println(member.getId() + " / " + member.getName());*/

        // 수정
        tx.begin();
        try {
            Member member = em.find(Member.class, 2L);
            member.setName("jihye2");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }


        // 삭제
        /*Member member = em.find(Member.class, 1L);
        tx.begin();
        try {
            em.remove(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }*/
    }
}
