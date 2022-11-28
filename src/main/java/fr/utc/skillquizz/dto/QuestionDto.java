package fr.utc.skillquizz.dto;


import fr.utc.skillquizz.models.Answer;
import fr.utc.skillquizz.models.Version;

import javax.persistence.*;
import java.io.Serializable;

public class QuestionDto implements Serializable {
    private int id;
    private int order;
    private String text;
    private boolean active;
    private fr.utc.skillquizz.models.Version version;
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

    public fr.utc.skillquizz.models.Version getVersion() {
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

