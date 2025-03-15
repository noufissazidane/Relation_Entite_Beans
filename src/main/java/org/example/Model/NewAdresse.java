package org.example.Model;

import jakarta.persistence.*;

@Entity(name="NewAdresse")
public class NewAdresse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 25)
    private String rue;
    private String ville;
    private String postalCode;
    private String pays;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    protected NewStudent student;


    public NewAdresse() {}
    public NewAdresse(String rue, String ville, String postalCode, String pays) {
        this.rue = rue;
        this.ville = ville;
        this.postalCode = postalCode;
        this.pays = pays;
        this.student = new NewStudent();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }

    public NewStudent getStudent() {
        return student;
    }
    public void setStudent(NewStudent student) {
        this.student = student;
    }



}
