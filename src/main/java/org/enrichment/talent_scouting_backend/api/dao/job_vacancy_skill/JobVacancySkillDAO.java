package org.enrichment.talent_scouting_backend.api.dao.job_vacancy_skill;

import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;

public interface JobVacancySkillDAO {
    JobVacancySkill addSkill(JobVacancySkill skill);
    JobVacancySkill getJobVacancySkill(Long jobVacancyId, Long skillId);
    void deleteSkill(Long jobVacancyId, Long skillId);
}
