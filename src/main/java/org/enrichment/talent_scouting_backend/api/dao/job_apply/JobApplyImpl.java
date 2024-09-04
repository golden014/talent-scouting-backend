package org.enrichment.talent_scouting_backend.api.dao.job_apply;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobApplyImpl implements JobApplyDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public JobApply save(JobApply jobApply) {
        entityManager.persist(jobApply);
        return jobApply;
    }

    @Override
    public JobApply getJobApply(Long jobId) {
        return entityManager.find(JobApply.class, jobId);
    }

    @Override
    public List<JobApply> getAllJobApplys(Long jobVacancyId) {
        System.out.println(jobVacancyId);
        String hql = "FROM JobApply ja WHERE ja.jobVacancy.id = :jobVacancyId";
        TypedQuery<JobApply> query = entityManager.createQuery(hql, JobApply.class);
        query.setParameter("jobVacancyId", jobVacancyId);
        return query.getResultList();
    }

    @Override
    public JobApply updateJobApply(JobApply jobApply) {
        return entityManager.merge(jobApply);
    }
}
