package org.enrichment.talent_scouting_backend.service.job_vacancy_skill;

import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;

import java.util.List;

public interface JobVacancySkillService {
    JobVacancySkill addSkill(JobVacancySkill skill);
    JobVacancySkill getJobVacancySkill(long jobVacancyId, long skillId);
    void deleteSkill(long jobVacancyId, long skillId);
    List<JobVacancySkill> addSkills(List<JobVacancySkill> skills);
}
