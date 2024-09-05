package org.enrichment.talent_scouting_backend.api.dao.job_apply;

import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;

import java.util.List;

public interface JobApplyDAO {
    JobApply save(JobApply jobApply);
    JobApply getJobApply(Long jobId);
    List<JobApply> getAllJobApplys(Long job_vacancy_id);
    JobApply updateJobApply(JobApply jobApply);
    List<JobApply> getJobApplyByStudentId(Long studentId);
    Integer getJobApplyCountByVacancyId(Long vacancyId);
}
