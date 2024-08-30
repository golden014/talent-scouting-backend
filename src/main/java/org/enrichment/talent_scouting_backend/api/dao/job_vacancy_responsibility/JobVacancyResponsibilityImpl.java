package org.enrichment.talent_scouting_backend.api.dao.job_vacancy_responsibility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobVacancyResponsibilityImpl implements JobVacancyResponsibilityDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public JobVacancyResponsibility getJobVacancyResponsibility(long jobId) {
        return entityManager.find(JobVacancyResponsibility.class, jobId);
    }

    @Override
    public JobVacancyResponsibility addJobVacancyResponsibility(JobVacancyResponsibility responsibility) {
        entityManager.persist(responsibility);
        return responsibility;
    }

    @Override
    public List<JobVacancyResponsibility> getJobVacancyResponsibilitiesByVacancyId(long jobVacancyId) {
        String hql = "FROM JobVacancyResponsibility ja WHERE ja.jobVacancy.id = :jobVacancyId";
        TypedQuery<JobVacancyResponsibility> query = entityManager.createQuery(hql, JobVacancyResponsibility.class);
        query.setParameter("jobVacancyId", jobVacancyId);
        return query.getResultList();
    }

    @Override
    public void deleteJobVacancyResponsibility(long jobvacancyResponsibilityId) {

    }
}
