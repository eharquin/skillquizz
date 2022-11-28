package fr.utc.skillquizz.dto;

import fr.utc.skillquizz.models.Skill;
import fr.utc.skillquizz.models.User;

import java.io.Serializable;

public class QuizzDto implements Serializable {
    private int id;
    private long userId;
    private long skillId;
    private boolean active;


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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }
}
