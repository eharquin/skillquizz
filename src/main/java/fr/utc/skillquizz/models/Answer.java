package fr.utc.skillquizz.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int order;
    private String text;
    @ManyToOne
    private Question question;
    @ManyToMany(mappedBy = "answers")
    Set<Course> courses = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getText() {
        return text;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
