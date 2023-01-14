package fr.utc.skillquizz.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "quizz_id")
    private Quizz quizz;
    private int order;
    private String text;
    private boolean active;
    @OneToOne
    private Version version;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
    @OneToOne
    @JoinColumn(name = "right_answer", referencedColumnName = "id")
    private Answer goodAnswer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(Answer goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

}
