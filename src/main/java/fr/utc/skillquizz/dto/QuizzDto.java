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
    private Integer worstScore;
    private Integer bestScore;
    private Integer avgScore;

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
    public Integer getWorstScore() {
        return worstScore;
    }

    public void setWorstScore(Integer worstScore) {
        this.worstScore = worstScore;
    }

    public Integer getBestScore() {
        return bestScore;
    }

    public void setBestScore(Integer bestScore) {
        this.bestScore = bestScore;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }
}
