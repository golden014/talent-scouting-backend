package org.enrichment.talent_scouting_backend.api.dao.skill;

import jakarta.persistence.EntityManager;
import org.enrichment.talent_scouting_backend.api.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SkillDAOImpl implements SkillDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public Skill getSkill(Long skillId) {
        return entityManager.find(Skill.class, skillId);
    }

    @Override
    public Skill addSkill(Skill skill) {
        entityManager.persist(skill);
        return skill;
    }

    @Override
    public void removeSkill(Skill skill) {
        entityManager.remove(skill);
    }
}
