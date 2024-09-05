package org.enrichment.talent_scouting_backend.api.dao.job_apply;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
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

    @Override
    public List<JobApply> getJobApplyByStudentId(Long studentId) {
        String hql = "FROM JobApply ja WHERE ja.student.id = :studentId";
        TypedQuery<JobApply> query = entityManager.createQuery(hql, JobApply.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public Integer getJobApplyCountByVacancyId(Long vacancyId) {
        String hql = "SELECT COUNT(ja) FROM JobApply ja WHERE ja.jobVacancy.id = :vacancyId";
        TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
        query.setParameter("vacancyId", vacancyId);
        return Math.toIntExact(query.getSingleResult());
    }
}
