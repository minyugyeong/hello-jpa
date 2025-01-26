package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //code
        Member member = new Member();
        member.setId(1L);
        member.setName("HelloA");
        em.persist(member);

        em.close();

        emf.close();
    }
}
