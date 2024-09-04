package org.enrichment.talent_scouting_backend.service.job_apply;

import org.enrichment.talent_scouting_backend.api.dao.job_apply.JobApplyDAO;
import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobApplyServiceImpl implements JobApplyService{

    @Autowired
    private JobApplyDAO jobApplyDAO;

    @Transactional
    @Override
    public JobApply save(JobApply jobApply) {
        return jobApplyDAO.save(jobApply);
    }

    @Transactional
    @Override
    public JobApply getJobApply(Long jobId) {
       return jobApplyDAO.getJobApply(jobId);
    }

    @Transactional
    @Override
    public List<JobApply> getAllJobApplys(Long job_vacancy_id) {
        return jobApplyDAO.getAllJobApplys(job_vacancy_id);
    }
}
