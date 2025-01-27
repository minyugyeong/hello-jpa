package jpateam;

import jpateam.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, findTeamId);

            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = " + findTeam.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
