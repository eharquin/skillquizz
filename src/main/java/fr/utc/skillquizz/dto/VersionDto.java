package fr.utc.skillquizz.dto;

import fr.utc.skillquizz.models.Quizz;

public class VersionDto {
    private int id;
    private boolean active;
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
