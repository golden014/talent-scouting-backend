package org.enrichment.talent_scouting_backend.service.job_vacancy_responsibility;

import org.enrichment.talent_scouting_backend.api.dao.job_vacancy_responsibility.JobVacancyResponsibilityDAO;
import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobVacancyResponsibilityServiceImpl implements JobVacancyResponsibilityService {

    @Autowired
    JobVacancyResponsibilityDAO jobVacancyResponsibilityDAO;

    @Transactional
    @Override
    public JobVacancyResponsibility getJobVacancyResponsibility(long jobId) {
        return jobVacancyResponsibilityDAO.getJobVacancyResponsibility(jobId);
    }

    @Transactional
    @Override
    public JobVacancyResponsibility addJobVacancyResponsibility(JobVacancyResponsibility responsibility) {
        return jobVacancyResponsibilityDAO.addJobVacancyResponsibility(responsibility);
    }

    @Transactional
    @Override
    public List<JobVacancyResponsibility> getJobVacancyResponsibilitiesByVacancyId(long jobVacancyId) {
        return jobVacancyResponsibilityDAO.getJobVacancyResponsibilitiesByVacancyId(jobVacancyId);
    }

    @Transactional
    @Override
    public void deleteJobVacancyResponsibility(long jobvacancyResponsibilityId) {
        jobVacancyResponsibilityDAO.deleteJobVacancyResponsibility(jobvacancyResponsibilityId);
    }

    @Transactional
    @Override
    public List<JobVacancyResponsibility> addJobVacancyResponsibilites(List<JobVacancyResponsibility> responsibilities) {
        for (JobVacancyResponsibility responsibility : responsibilities) {
            addJobVacancyResponsibility(responsibility);
        }
        return responsibilities;
    }
}
