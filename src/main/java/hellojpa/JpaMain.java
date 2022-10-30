package hellojpa;

import hellojpa.OneToOne.Locker;
import hellojpa.OneToOne.Student;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            Team team = new Team();
            team.setTeamName("ManchesterUTD");
            em.persist(team);
            em.flush();
            em.clear();

            Team team1 = em.find(Team.class, team.getTeamId());
//            System.out.println("실제 엔티티 : " + team1.getClass());
//            em.flush();
//            em.clear();
            Team reference = em.getReference(Team.class, team.getTeamId());
//            System.out.println("프록시 엔티티 : " + reference.getClass());
//            System.out.println(team1 == reference);

            em.flush();
            em.clear();

            Team team2 = new Team();
            team2.setTeamName("chelsea");

            em.persist(team2);

            em.flush();
            em.clear();

            Team chelsea = em.getReference(Team.class, team2.getTeamId());

            em.detach(chelsea);

//            System.out.println(chelsea.getTeamName()); // 초기화 할 수 없음


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
