package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "support")
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSupp;

    @Column(length = 100)
    private String titre;

    @Column(length = 255)
    private String descr;

    @Column(length = 50)
    private String typeSuppt;

    private LocalDate dateAjout;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;

    public Support(String titre, String descr, String typeSuppt, LocalDate dateAjout, Quiz quiz) {
        this.titre = titre;
        this.descr = descr;
        this.typeSuppt = typeSuppt;
        this.dateAjout = dateAjout;
        this.quiz = quiz;
    }

    public int getIdSupp() { return idSupp; }
    public void setIdSupp(int idSupp) { this.idSupp = idSupp; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescr() { return descr; }
    public void setDescr(String descr) { this.descr = descr; }

    public String getTypeSuppt() { return typeSuppt; }
    public void setTypeSuppt(String typeSuppt) { this.typeSuppt = typeSuppt; }

    public LocalDate getDateAjout() { return dateAjout; }
    public void setDateAjout(LocalDate dateAjout) { this.dateAjout = dateAjout; }

    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
}
