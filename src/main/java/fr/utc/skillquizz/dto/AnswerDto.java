package fr.utc.skillquizz.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class AnswerDto {
    private int id;
    private int order;
    private String text;

    private Question question;

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
