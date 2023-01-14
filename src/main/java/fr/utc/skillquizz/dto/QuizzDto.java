package fr.utc.skillquizz.dto;

import fr.utc.skillquizz.models.Question;
import fr.utc.skillquizz.models.Skill;
import fr.utc.skillquizz.models.User;

import java.io.Serializable;
import java.util.List;

public class QuizzDto implements Serializable {
    private int id;
    private Skill skill;
    private boolean active;
    private List<Question> questions;
    private int worstScore;
    private int bestScore;
    private int avgScore;

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public int getWorstScore() {
        return worstScore;
    }

    public void setWorstScore(int worstScore) {
        this.worstScore = worstScore;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public int getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }
}
