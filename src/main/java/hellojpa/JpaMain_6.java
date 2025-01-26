package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain_6 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member); //em.detach(entity) : 특정 엔티티만 준영속 상태로 전환
//            em.clear(); //영속성 컨텍스트를 완전히 초기화

            System.out.println("===================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //영속성 컨텍스트를 종료
        }

        emf.close();
    }
}
