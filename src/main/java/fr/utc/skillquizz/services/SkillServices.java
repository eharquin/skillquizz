package fr.utc.skillquizz.services;

import fr.utc.skillquizz.models.Skill;
import fr.utc.skillquizz.repositories.SkillRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SkillServices {

    @Autowired
    private final SkillRepository skillRepository;

    public SkillServices(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }


    public void deleteSkill(Long skillId){
        this.skillRepository.findById(skillId);
        this.skillRepository.deleteAnswerById(skillId);
    }

    public Skill createSkill(Skill skill){
        System.out.println("Skill : " + skill.getSubject());
        return this.skillRepository.save(skill);
    }
}
