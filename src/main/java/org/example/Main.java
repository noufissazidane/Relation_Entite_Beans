package org.example;

import org.example.DAO.StudentDAO;
import org.example.Model.Cours;
import org.example.Model.NewAdresse;
import org.example.Model.NewStudent;
import org.example.Model.Prof;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDao = new StudentDAO();


        NewStudent student = new NewStudent();
        student.setId(3);
        student.setNom("Zidane");
        student.setPrenom("Noufissa");
        student.setEmail("zidane@gmail.com");
        student.setFilliere("GI");
        student.setYear("2025");
        student.setNote(16);

        NewStudent student2 = new NewStudent();
        student2.setId(4);
        student2.setNom("Zemri");
        student2.setPrenom("chaimae");
        student2.setEmail("zemri@gmail.com");
        student2.setFilliere("GI");
        student2.setYear("2025");
        student2.setNote(16);

        List<NewStudent> students = new ArrayList<>();
        students.add(student);
        students.add(student2);

        NewAdresse address = new NewAdresse();
        address.setRue("Azzouzia");
        address.setVille("Marrakech");
        address.setPays("Maroc");
        address.setPostalCode("90210");

        NewAdresse address2 = new NewAdresse();
        address2.setRue("El Massira");
        address2.setVille("Marrakech");
        address2.setPays("Maroc");
        address2.setPostalCode("83749");


        Cours course1 = new Cours();
        course1.setModule("Java");
        course1.setSemestre("S4");
        course1.setHeure(8);

        Cours course2 = new Cours();
        course2.setModule("Deep learning");
        course2.setSemestre("S4");
        course2.setHeure(4);

        List<Cours> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        Prof prof1 = new Prof();
        prof1.setNomcomplet("MR. ATLAS");

        Prof prof2 = new Prof();
        prof2.setNomcomplet("MR. JABRANE");

        address.setStudent(student);
        address2.setStudent(student2);

        student.setAddress(address);
        student2.setAddress(address2);

        student.setCourses(courses);
        student2.setCourses(courses);

        course1.setProf(prof1);
        course2.setProf(prof2);


        prof1.setCourses(courses);
        prof2.setCourses(courses);

        studentDao.addStudent(student);
        studentDao.addStudent(student2);


    }
}
