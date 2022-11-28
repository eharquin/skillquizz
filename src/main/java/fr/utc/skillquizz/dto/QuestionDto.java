package fr.utc.skillquizz.dto;

import java.io.Serializable;

public class QuestionDto implements Serializable {
    private int id;
    private int order;
    private String text;
    private boolean active;
    private long versionId;

    private long goodAnswerId;

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

    public long getVersionId() {
        return versionId;
    }

    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    public long getGoodAnswerId() {
        return goodAnswerId;
    }

    public void setGoodAnswerId(long goodAnswerId) {
        this.goodAnswerId = goodAnswerId;
    }
}

