package org.enrichment.talent_scouting_backend.api.dao.job_vacancy_responsibility;

import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;

import java.util.List;

public interface JobVacancyResponsibilityDAO {
    JobVacancyResponsibility getJobVacancyResponsibility(long jobId);
    JobVacancyResponsibility addJobVacancyResponsibility(JobVacancyResponsibility responsibility);
    List<JobVacancyResponsibility> getJobVacancyResponsibilitiesByVacancyId(long jobVacancyId);
    void deleteJobVacancyResponsibility(long jobvacancyResponsibilityId);
}
