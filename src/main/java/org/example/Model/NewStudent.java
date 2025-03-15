package org.example.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="NewStudent")
public class NewStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 25)
    private String nom;
    private String prenom;
    @Column(length = 50)
    private String filliere;
    @Column
    private double note;
    @Column(length = 50)
    private String email;
    @Column(length = 11)
    private String year;

    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private NewAdresse address;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_cours",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id")
    )
    private List<Cours> cours;

    public NewStudent() {
    }

    public NewStudent(String nom, String prenom, String filliere, double note, String email, String year, NewAdresse address) {
        this.nom = nom;
        this.prenom = prenom;
        this.filliere = filliere;
        this.note = note;
        this.email = email;
        this.year = year;
        this.address = address;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getFilliere() {
        return filliere;
    }

    public double getNote() {
        return note;
    }

    public String getEmail() {
        return email;
    }

    public String getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setFilliere(String filliere) {
        this.filliere = filliere;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public NewAdresse getAddress() {
        return address;
    }

    public void setAddress(NewAdresse address) {
        this.address = address;
    }

    public List<Cours> getCourses() {
        return cours;
    }

    public void setCourses(List<Cours> courses) {
        this.cours = courses;
    }
}
