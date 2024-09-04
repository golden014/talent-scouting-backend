package org.enrichment.talent_scouting_backend.service.job_apply;

import org.enrichment.talent_scouting_backend.api.model.JobApply;

import java.util.List;

public interface JobApplyService {
    JobApply save(JobApply jobApply);
    JobApply getJobApply(Long jobId);
    List<JobApply> getAllJobApplys(Long job_vacancy_id);
    JobApply updateJobApply(JobApply jobApply);

}
