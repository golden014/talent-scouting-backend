package org.enrichment.talent_scouting_backend.service.skill;

import org.enrichment.talent_scouting_backend.api.model.Skill;

import java.util.List;

public interface SkillService {
    Skill getSkill(Long skillId);

    Skill addSkill(Skill skill);

    void removeSkill(Skill skill);

    List<Skill> getAllSkill();
}
