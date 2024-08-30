package org.enrichment.talent_scouting_backend.api.dao.job_vacancy_skill;

import jakarta.persistence.EntityManager;
import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;
import org.enrichment.talent_scouting_backend.api.model.id.JobVacancySkillID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobVacancySkillImpl implements JobVacancySkillDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public JobVacancySkill addSkill(JobVacancySkill skill) {
        entityManager.persist(skill);
        return skill;
    }

    @Override
    public JobVacancySkill getJobVacancySkill(long jobVacancyId, long skillId) {
        //bikin composite key nya dulu
        JobVacancySkillID id = new JobVacancySkillID(jobVacancyId, skillId);
        return entityManager.find(JobVacancySkill.class, id);
    }

    @Override
    public void deleteSkill(long jobVacancyId, long skillId) {
        entityManager.remove(getJobVacancySkill(jobVacancyId, skillId));
    }
}
