package fr.utc.skillquizz.controllers;

import fr.utc.skillquizz.dto.SkillDto;
import fr.utc.skillquizz.models.Skill;
import fr.utc.skillquizz.services.SkillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController extends BaseController{

    @Autowired
    private SkillServices skillService;

    @GetMapping(path = "/skill", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SkillDto> index() {
        List<Skill> skills = skillService.getSkills();
        List<SkillDto> skillDtos = mapList(skills, SkillDto.class);
        return skillDtos;
    }

    @GetMapping(path = "/skill/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SkillDto show(@PathVariable Long id) {
        Skill skill = skillService.getSkill(id);
        return convertToDto(skill);
    }

    @PostMapping("/skill")
    public void store(@RequestBody SkillDto skillDto) {
        Skill skill = convertToEntity(skillDto);
        skillService.createSkill(skill);
    }

    @PatchMapping("/skill/{id}")
    public void update(@PathVariable long id, @RequestBody SkillDto skillDto) {
        Skill skill = convertToEntity(skillDto);
        skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/skill/{id}")
    public void destroy(@PathVariable long id) {
        skillService.deleteSkill(id);
    }

    private SkillDto convertToDto(Skill skill) {
        SkillDto skillDto = getModelMapper().map(skill, SkillDto.class);

        return skillDto;
    }

    private Skill convertToEntity(SkillDto skillDto) {
        Skill skill = getModelMapper().map(skillDto, Skill.class);

        return skill;
    }

}
