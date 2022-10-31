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

            Player player = new Player();
            player.setName("wilson");
            em.persist(player);


            Team team = new Team();
            team.setTeamName("newcastle");
            player.setTeam(team);
            em.persist(team);

            em.flush();
            em.clear();

//            Player findPlayer = em.find(Player.class, player.getId());
            List<Player> select_p_from_player = em.createQuery("select p from Player p", Player.class).getResultList();
//            System.out.println(findPlayer.getTeam().getClass());

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
