package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Model.Prof;

import java.util.List;

public class ProfDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewStudent");
    private EntityManager em = emf.createEntityManager();

    public void addProf(Prof prof) {
        em.getTransaction().begin();
        em.persist(prof);
        em.getTransaction().commit();
    }

    public void updateProf(Prof prof) {
        em.getTransaction().begin();
        em.merge(prof);
        em.getTransaction().commit();
    }

    public void deleteProf(int id) {
        em.getTransaction().begin();
        Prof prof = em.find(Prof.class, id);
        if (prof != null) {
            em.remove(prof);
        }
        em.getTransaction().commit();
    }

    public List<Prof> getAllProfs() {
        return em.createQuery("SELECT s FROM Prof s", Prof.class).getResultList();
    }
}
