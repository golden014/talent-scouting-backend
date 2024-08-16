package org.enrichment.talent_scouting_backend.service.job_vacancy;

import org.enrichment.talent_scouting_backend.api.dao.job_vacancy.JobVacancyDAO;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobVacancyServiceImpl implements JobVacancyService {

    @Autowired
    JobVacancyDAO jobVacancyDAO;

    @Transactional
    @Override
    public JobVacancy addJobVacancy(JobVacancy jobVacancy) {
        return jobVacancyDAO.addJobVacancy(jobVacancy);
    }

    @Transactional
    @Override
    public void deleteJobVacancy(JobVacancy jobVacancy) {
        jobVacancyDAO.deleteJobVacancy(jobVacancy);
    }
}
