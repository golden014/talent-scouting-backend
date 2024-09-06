package org.enrichment.talent_scouting_backend.api.dao.job_vacancy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.enrichment.talent_scouting_backend.api.dto.JobVacancyAllAttributes;
import org.enrichment.talent_scouting_backend.api.model.*;
import org.enrichment.talent_scouting_backend.api.dto.JobVacancyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public JobVacancyAllAttributes getJobVacancyByID(Long jobVacancyId) {
//        return entityManager.find(JobVacancy.class, jobVacancyID);
        String query = "SELECT DISTINCT jv, jvs, jvr, ei FROM JobVacancy jv " +
                " LEFT JOIN JobVacancySkill jvs ON jv.id = jvs.jobVacancy.id " +
                " LEFT JOIN JobVacancyResponsibility jvr ON jv.id = jvr.jobVacancy.id " +
                " LEFT JOIN ExtrasInfo ei ON jv.id = ei.jobVacancy.id " +
                "WHERE jv.id = :jobVacancyId";

        List<Object[]> result = entityManager.createQuery(query)
                .setParameter("jobVacancyId", jobVacancyId)
                .getResultList();

        if (result.isEmpty()) {
            return null;
        }

        // extract jobVacancy and all attributes from the result
        JobVacancy jobVacancy = null;
        List<JobVacancySkill> jobVacancySkills = new ArrayList<>();
        List<JobVacancyResponsibility> jobVacancyResponsibilities = new ArrayList<>();
        List<ExtrasInfo> extrasInfos = new ArrayList<>();

        for (Object[] row : result) {
            jobVacancy = (JobVacancy) row[0];
            JobVacancySkill jobVacancySkill = (JobVacancySkill) row[1];
            JobVacancyResponsibility jobVacancyResponsibility = (JobVacancyResponsibility) row[2];
            ExtrasInfo extrasInfo = (ExtrasInfo) row[3];


            if (jobVacancySkill != null) {
                jobVacancySkills.add(jobVacancySkill);
            }

            if (jobVacancyResponsibility != null) {
                jobVacancyResponsibilities.add(jobVacancyResponsibility);
            }

            if (extrasInfo != null) {
                extrasInfos.add(extrasInfo);
            }
        }

        List<JobVacancySkill> uniqueJobVacancySkill = new ArrayList<>(jobVacancySkills.stream()
                .collect(Collectors.toMap(JobVacancySkill::getJobVacancySkillPK, p -> p, (existing, replacement) -> existing))
                .values());

        List<JobVacancyResponsibility> uniqueJobVacancyResponsibility = new ArrayList<>(jobVacancyResponsibilities.stream()
                .collect(Collectors.toMap(JobVacancyResponsibility::getId, p -> p, (existing, replacement) -> existing))
                .values());

        List<ExtrasInfo> uniqueExtrasInfo = new ArrayList<>(extrasInfos.stream()
                .collect(Collectors.toMap(ExtrasInfo::getId, p -> p, (existing, replacement) -> existing))
                .values());


        return new JobVacancyAllAttributes(jobVacancy, uniqueJobVacancySkill, uniqueJobVacancyResponsibility, uniqueExtrasInfo);
    }

    @Override
    public List<JobVacancy> getJobVacanciesByFilters(JobVacancyFilter jobVacancyFilter) {
        //criteria builder = factory utk build kriteria dari query
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //define query akan dipakai utk class ambil object apa
        CriteriaQuery<JobVacancy> query = cb.createQuery(JobVacancy.class);
        //define query akan select dari table apa
        Root<JobVacancy> jobVacancy = query.from(JobVacancy.class);

        // join sama company supaya saat keyword match sama nama company, bisa ketemu
        Join<JobVacancy, Company> company = jobVacancy.join("company");

        //predicate = conditions/criteria
        List<Predicate> predicates = new ArrayList<>();

        //cek apakah di request ada pass location atau engga, jika ada, cari yg match di DB
        if (jobVacancyFilter.getLocation() != null && !jobVacancyFilter.getLocation().isEmpty()) {
            //tambahin ke list conditions
            predicates.add(cb.equal(jobVacancy.get("location"), jobVacancyFilter.getLocation()));
        }

        if (jobVacancyFilter.getJobPosition() != null && !jobVacancyFilter.getJobPosition().isEmpty()) {
            predicates.add(cb.equal(jobVacancy.get("jobPosition"), jobVacancyFilter.getJobPosition()));
        }



        if (!jobVacancyFilter.getJobTypeId().isEmpty()) {
            predicates.add(cb.equal(jobVacancy.get("jobType").get("id"), jobVacancyFilter.getJobTypeId()));
        }

        //kalau ada kasih search keyword
        if (jobVacancyFilter.getSearchKeyword() != null && !jobVacancyFilter.getSearchKeyword().isEmpty()) {
            //lower case keywordnya, pattern matching
            String searchPattern = "%" + jobVacancyFilter.getSearchKeyword().toLowerCase() + "%";

            //cari yg match dengan job position/job description/company name
            Predicate jobPositionPredicate = cb.like(cb.lower(jobVacancy.get("jobPosition")), searchPattern);
//            Predicate jobDescriptionPredicate = cb.like(cb.lower(jobVacancy.get("jobDescription")), searchPattern);
            Predicate jobDescriptionPredicate = cb.like(jobVacancy.get("jobDescription"), searchPattern);

//            Predicate jobDescriptionPredicate = cb.like(cb.lower(cb.function("TO_CHAR", String.class, jobVacancy.get("jobDescription"))), searchPattern);
            Predicate companyNamePredicate = cb.like(cb.lower(company.get("name")), searchPattern);

            predicates.add(cb.or(jobPositionPredicate, jobDescriptionPredicate, companyNamePredicate));
        }
        //utk apply predicate (conditions) ke query where
        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<JobVacancy> getJobVacancyByCompanyId(Long companyID) {
        System.out.println(companyID);
        String hql = "FROM JobVacancy ja WHERE ja.company.id = :companyId";
        TypedQuery<JobVacancy> query = entityManager.createQuery(hql, JobVacancy.class);
        query.setParameter("companyId", companyID);
        return query.getResultList();
    }

    @Override
    public List<JobVacancy> getTopJobVacancy(Long topCount) {
        //mengambil {top count} job vacancy berdasarkan jumlah student yang apply
        String query = "SELECT jv " +
                "FROM JobVacancy jv " +
                "LEFT JOIN JobApply ja ON jv.id = ja.jobVacancy.id " +
                "GROUP BY jv.id " +
                "ORDER BY COUNT(ja.id) DESC";

        return entityManager.createQuery(query, JobVacancy.class)
                .setMaxResults(Math.toIntExact(topCount)) //limit top based on top count nya
                .getResultList();
    }

    @Override
    public List<JobVacancy> getLatestJobVacancyByCompanyId(Long companyId, Long latestCount) {

        String hql = "SELECT jv FROM JobVacancy jv " +
                "WHERE jv.company.id = :companyId " +
                "ORDER BY jv.timeStamp DESC";

        TypedQuery<JobVacancy> query = entityManager.createQuery(hql, JobVacancy.class);
        query.setParameter("companyId", companyId);

        return query.setMaxResults(Math.toIntExact(latestCount)).getResultList();
    }

    @Override
    public List<String> getJobVacancyLocations() {
        String query = "SELECT DISTINCT jv.location FROM JobVacancy jv";
        return entityManager.createQuery(query, String.class).getResultList();
    }
}
