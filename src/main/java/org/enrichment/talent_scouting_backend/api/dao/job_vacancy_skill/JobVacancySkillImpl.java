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
        System.out.println(skill.getSkill());
        System.out.println(skill.getSkillDetail());
        System.out.println(skill.getJobVacancySkillPK());
        System.out.println(skill.getJobVacancy());

        entityManager.persist(skill);
        return skill;
    }

    @Override
    public JobVacancySkill getJobVacancySkill(Long jobVacancyId, Long skillId) {
        //bikin composite key nya dulu
        JobVacancySkillID id = new JobVacancySkillID(jobVacancyId, skillId);
        return entityManager.find(JobVacancySkill.class, id);
    }

    @Override
    public void deleteSkill(Long jobVacancyId, Long skillId) {
        entityManager.remove(getJobVacancySkill(jobVacancyId, skillId));
    }
}
