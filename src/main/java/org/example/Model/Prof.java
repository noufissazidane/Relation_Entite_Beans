package org.example.Model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prof;
    @Column
    private String nomcomplet;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "prof_courses",
            joinColumns = @JoinColumn(name = "prof_id"),
            inverseJoinColumns = @JoinColumn(name = "cours_id"))
    private List<Cours> cours;


    public String getNomcomplet() {
        return nomcomplet;
    }
    public void setNomcomplet(String nomcomplet) {
        this.nomcomplet = nomcomplet;
    }

    public int getId_prof() {
        return id_prof;
    }
    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public Prof() {}
    public Prof(int id_prof, String nomcomplet) {
        this.id_prof = id_prof;
        this.nomcomplet = nomcomplet;
    }

    public List<Cours> getCourses() {
        return cours;
    }
    public void setCourses(List<Cours> courses) {
        this.cours = courses;
    }


}
