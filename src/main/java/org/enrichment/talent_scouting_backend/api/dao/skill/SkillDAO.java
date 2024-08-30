package org.enrichment.talent_scouting_backend.api.dao.skill;

import org.enrichment.talent_scouting_backend.api.model.Skill;

public interface SkillDAO {

    Skill getSkill(Long skillId);

    Skill addSkill(Skill skill);

    void removeSkill(Skill skill);
}
