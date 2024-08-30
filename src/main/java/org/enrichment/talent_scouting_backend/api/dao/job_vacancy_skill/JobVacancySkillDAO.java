package org.enrichment.talent_scouting_backend.api.dao.job_vacancy_skill;

import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;

public interface JobVacancySkillDAO {
    JobVacancySkill addSkill(JobVacancySkill skill);
    JobVacancySkill getJobVacancySkill(long jobVacancyId, long skillId);
    void deleteSkill(long jobVacancyId, long skillId);
}
