package org.enrichment.talent_scouting_backend.api.dao.job_apply;

import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;

import java.util.List;

public interface JobApplyDAO {
    JobApply save(JobApply jobApply);
    JobApply getJobApply(long jobId);
    List<JobApply> getAllJobApplys(long job_vacancy_id);
}
