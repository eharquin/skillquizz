package fr.utc.skillquizz.models;

import javax.persistence.*;

@Entity
@Table(name="versions")
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean active;
    @ManyToOne
    private Quizz quizz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Quizz getSurvey() {
        return quizz;
    }

    public void setSurvey(Quizz quizz) {
        this.quizz = quizz;
    }
}
