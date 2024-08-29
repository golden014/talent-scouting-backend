package org.enrichment.talent_scouting_backend.api.dao.extras_info;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.enrichment.talent_scouting_backend.api.model.ExtrasInfo;
import org.enrichment.talent_scouting_backend.api.model.JobApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExtrasInfoImpl implements ExtrasInfoDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public ExtrasInfo addExtrasInfo(ExtrasInfo extrasInfo) {
        entityManager.persist(extrasInfo);
        return extrasInfo;
    }

    @Override
    public ExtrasInfo updateExtrasInfo(ExtrasInfo extrasInfo) {
        return entityManager.merge(extrasInfo);
    }

    @Override
    public void deleteExtrasInfo(ExtrasInfo extrasInfo) {
        entityManager.remove(extrasInfo);
    }

    @Override
    public List<ExtrasInfo> getExtrasInfosByJobVacancy(Long jobVacancyId) {
        String jpql = "SELECT e FROM ExtrasInfo e WHERE e.jobVacancy.id = :jobVacancyId";
        return entityManager.createQuery(jpql, ExtrasInfo.class)
                .setParameter("jobVacancyId", jobVacancyId)
                .getResultList();

//        String hql = "FROM ExtrasInfo ja WHERE ja.jobVacancy.id = :jobVacancyId";
//        TypedQuery<ExtrasInfo> query = entityManager.createQuery(hql, ExtrasInfo.class);
//        query.setParameter("jobVacancyId", job_vacancy_id);
//        return query.getResultList();
    }
}
