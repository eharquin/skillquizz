package fr.utc.skillquizz.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int duration;
    private int score;
    @ManyToOne
    private Quizz quizz;
    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "answers_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    Set<Answer> answers = new HashSet<>();
}
