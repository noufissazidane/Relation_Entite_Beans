package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Model.NewAdresse;
import org.example.Model.NewStudent;

import java.util.List;

public class AdresseDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewStudent");
    private EntityManager em = emf.createEntityManager();

    public void addAddresse(NewAdresse addresse) {
        em.getTransaction().begin();
        em.persist(addresse);
        em.getTransaction().commit();
    }

    public void updateAddresse(NewAdresse addresse) {
        em.getTransaction().begin();
        em.merge(addresse);
        em.getTransaction().commit();
    }

    public void deleteAddresse(int id) {
        em.getTransaction().begin();
        NewAdresse addresse = em.find(NewAdresse.class, id);
            if (addresse != null) {
            em.remove(addresse);
        }
        em.getTransaction().commit();
    }

    public List<NewAdresse> getAllAddresses() {
        return em.createQuery("SELECT s FROM NewAdresse s", NewAdresse.class).getResultList();
    }

}
