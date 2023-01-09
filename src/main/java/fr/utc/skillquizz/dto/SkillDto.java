package fr.utc.skillquizz.dto;

public class SkillDto {
    private int id;
    private String subject;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getSubject() {
        return this.subject;
    }
}
