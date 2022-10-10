package fr.utc.skillquizz.dto;

import fr.utc.skillquizz.models.Skill;
import fr.utc.skillquizz.models.User;

public class QuizzDto {
    private int id;
    private User user;
    private Skill skill;
    private boolean active;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
