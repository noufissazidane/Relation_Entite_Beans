package org.example.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cours;

    @Column(length = 25)
    private String module;
    private String semestre;
    @Column
    private int heure;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<NewStudent> students;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Prof prof;


    public Cours() {}
    public Cours(String module, String semestre, int heure) {
        this.module = module;
        this.semestre = semestre;
        this.heure = heure;
    }

    public int getId_cours() {
        return id_cours;
    }
    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public int getHeure() {
        return heure;
    }
    public void setHeure(int heure) {
        this.heure = heure;
    }

    public List<NewStudent> getStudents() {
        return students;
    }
    public void setStudents(List<NewStudent> students) {
        this.students = students;
    }

    public Prof getProf() {
        return prof;
    }
    public void setProf(Prof prof) {
        this.prof = prof;
    }




}
