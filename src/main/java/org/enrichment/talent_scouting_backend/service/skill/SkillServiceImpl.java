package org.enrichment.talent_scouting_backend.service.skill;

import org.enrichment.talent_scouting_backend.api.dao.skill.SkillDAO;
import org.enrichment.talent_scouting_backend.api.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService{

    @Autowired
    SkillDAO skillDAO;

    @Transactional
    @Override
    public Skill getSkill(Long skillId) {
        return skillDAO.getSkill(skillId);
    }

    @Transactional
    @Override
    public Skill addSkill(Skill skill) {
        return skillDAO.addSkill(skill);
    }
    @Transactional
    @Override
    public void removeSkill(Skill skill) {
        skillDAO.removeSkill(skill);
    }

    @Transactional
    @Override
    public List<Skill> getAllSkill() {
        return skillDAO.getAllSkill();
    }
}
