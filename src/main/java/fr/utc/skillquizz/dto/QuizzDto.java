package fr.utc.skillquizz.dto;

import fr.utc.skillquizz.models.Question;
import fr.utc.skillquizz.models.Skill;
import fr.utc.skillquizz.models.User;

import java.io.Serializable;
import java.util.List;

public class QuizzDto implements Serializable {
    private int id;
    private String skill;
    private boolean active;
    private List<Question> questions;

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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skillId) {
        this.skill = skillId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
