package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.model.Skill;
import org.enrichment.talent_scouting_backend.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/getSkillByID")
    public Skill getSkillByID(@RequestParam long id) {
        return skillService.getSkill(id);
    }

    @PostMapping("/addNewSkill")
    public Skill addNewSkill(Skill skill) {
        return skillService.addSkill(skill);
    }

    @PostMapping("/deleteSkill")
    public void deleteSkill(Skill skill) {
        skillService.removeSkill(skill);
    }

    @GetMapping("/getAllSkill")
    public List<Skill> getAllSkill() {
        return skillService.getAllSkill();
    }
}
