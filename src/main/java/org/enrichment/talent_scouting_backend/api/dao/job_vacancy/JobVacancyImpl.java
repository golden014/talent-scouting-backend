package org.enrichment.talent_scouting_backend.api.dao.job_vacancy;

import jakarta.persistence.EntityManager;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobVacancyImpl implements JobVacancyDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public JobVacancy addJobVacancy(JobVacancy jobVacancy) {
        entityManager.persist(jobVacancy);
        return jobVacancy;
    }

    @Override
    public void deleteJobVacancy(JobVacancy jobVacancy) {
        entityManager.remove(jobVacancy);
    }
}
