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
        try {
            tx.begin();
            /*Team team = new Team();
            team.setTeamName("Manchester.UTD");
            em.persist(team);
            Player player = new Player();
            player.setName("Rooney");
            player.setTeamId(team.getTeamId()); // 객체지향스럽지 않다.
            em.persist(player);*/

            Team team = new Team();
            team.setTeamName("NewCastle");

            em.persist(team);
            Player player = new Player();
            player.setName("Wilson");
            player.setTeam(team);
            em.persist(player);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }



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
        /*tx.begin();
        try {
            Member member = em.find(Member.class, 2L);
            member.setName("jihye2");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }*/


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

        /**
         * 1차 캐시 저장
         */
        /*Member member = new Member(3L , "test");
        tx.begin();
        em.persist(member);

        // 로그를 보면 SELECT 쿼리를 날리지 않음.
        // 위의 persist 하면서 3L의 Member를 1차 캐시에 저장해두었기 때문에
        // 같은 트랜잭션에 있는 find에서는 DB에서 select 해오는것이 아닌 1차 캐시에 있는 3L의 Member를 찾아온다
        em.find(Member.class, 3L);

        tx.commit();*/

        /**
         * 쓰기 지연
         */
        /*Member member1 = new Member(4L, "test2");
        Member member2 = new Member(5L, "test3");
        tx.begin();
        em.persist(member1);
        em.persist(member2);
        // 위의 persist에서 insert가 되는것이 아니라 영속성 컨텍스트 안의 쓰기 지연 쿼리 저장소에 차곡 차곡 쌓아 두고
        tx.commit(); // 트랜잭션의 commit 시점에 영속성 컨텍스트 안의 쓰기 지연 쿼리 저장소에 있는 쿼리를 DB에 날린다.*/

        /**
         * 엔티티 수정 감지 ( 더티 체크 )
         */
        /*Member member = em.find(Member.class, 5L);
        tx.begin();
        member.setName("updateTest"); // set만해도 update 가능.
        tx.commit();*/



    }
}
