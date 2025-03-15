package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Model.NewStudent;

import java.util.List;

public class StudentDAO {


    public void addStudent(NewStudent student) {
        EntityManager em = EntityManagerProvider.getInstance().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

//    public void updateStudent(NewStudent student) {
//        em.getTransaction().begin();
//        em.merge(student);
//        em.getTransaction().commit();
//    }
//
//    public void deleteStudent(int id) {
//        em.getTransaction().begin();
//        NewStudent student = em.find(NewStudent.class, id);
//        if (student != null) {
//            em.remove(student);
//        }
//        em.getTransaction().commit();
//    }
//
//    public List<NewStudent> getAllStudents() {
//        return em.createQuery("SELECT s FROM NewStudent s", NewStudent.class).getResultList();
//    }


}
