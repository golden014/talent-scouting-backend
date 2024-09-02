package org.enrichment.talent_scouting_backend.service.job_vacancy_responsibility;

import org.enrichment.talent_scouting_backend.api.dao.job_vacancy_responsibility.JobVacancyResponsibilityDAO;
import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobVacancyResponsibilityServiceImpl implements JobVacancyResponsibilityService {

    @Autowired
    JobVacancyResponsibilityDAO jobVacancyResponsibilityDAO;

    @Override
    public JobVacancyResponsibility getJobVacancyResponsibility(long jobId) {
        return jobVacancyResponsibilityDAO.getJobVacancyResponsibility(jobId);
    }

    @Override
    public JobVacancyResponsibility addJobVacancyResponsibility(JobVacancyResponsibility responsibility) {
        return jobVacancyResponsibilityDAO.addJobVacancyResponsibility(responsibility);
    }

    @Override
    public List<JobVacancyResponsibility> getJobVacancyResponsibilitiesByVacancyId(long jobVacancyId) {
        return jobVacancyResponsibilityDAO.getJobVacancyResponsibilitiesByVacancyId(jobVacancyId);
    }

    @Override
    public void deleteJobVacancyResponsibility(long jobvacancyResponsibilityId) {
        jobVacancyResponsibilityDAO.deleteJobVacancyResponsibility(jobvacancyResponsibilityId);
    }
}
