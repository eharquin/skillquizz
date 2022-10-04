package fr.utc.skillquizz.models;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int order;
    private String text;
    private boolean active;
    @OneToOne
    private Version version;
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

    public Answer getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(Answer goodAnswer) {
        this.goodAnswer = goodAnswer;
    }
}
