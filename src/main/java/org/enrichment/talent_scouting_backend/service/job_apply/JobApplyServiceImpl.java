package org.enrichment.talent_scouting_backend.service.job_apply;

import org.enrichment.talent_scouting_backend.api.dao.job_apply.JobApplyDAO;
import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplyServiceImpl implements JobApplyService{

    @Autowired
    private JobApplyDAO jobApplyDAO;

    @Override
    public JobApply save(JobApply jobApply) {
        return jobApplyDAO.save(jobApply);
    }

    @Override
    public JobApply getJobApply(long jobId) {
       return jobApplyDAO.getJobApply(jobId);
    }

    @Override
    public List<JobApply> getAllJobApplys(long job_vacancy_id) {
        return jobApplyDAO.getAllJobApplys(job_vacancy_id);
    }
}
