package application;

import domain.entity.Skill;
import domain.service.SkillService;

public class CreateSkillUseCase {
    private SkillService skillService;

    public CreateSkillUseCase(SkillService skillService) {
        this.skillService = skillService;
    }

    public void execute(Skill skill) {
        skillService.CreateSkill(skill);
    }
}
