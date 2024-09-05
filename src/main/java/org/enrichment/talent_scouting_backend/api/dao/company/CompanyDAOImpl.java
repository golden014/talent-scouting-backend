package org.enrichment.talent_scouting_backend.api.dao.company;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.*;
import org.enrichment.talent_scouting_backend.api.model.Company;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.dto.CompanyFilter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Company getCompany(int id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public Company save(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    public void deleteCompany(int id) {

    }

    @Override
    public List<Company> getAllCompanies() {
        Session session = entityManager.unwrap(Session.class);
        Query<Company> query = session.createQuery("from Company ", Company.class);
        return query.getResultList();
    }

    @Override
    public List<Company> addCompanyBulk(List<Company> companies) {
        for (Company company : companies) {
            entityManager.persist(company);
        }
        return companies;
    }

    @Override
    public Company authenticate(String email, String password) {
        try {
            return entityManager.createQuery(
                            "SELECT c FROM Company c WHERE c.email = :email AND c.password = :password",
                            Company.class)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Company> getCompanyByFilter(CompanyFilter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> query = cb.createQuery(Company.class);
        Root<Company> company = query.from(Company.class);

        //join sama jobvacancy supaya bisa filter dari field jobvacancy
        Join<Company, JobVacancy> jobVacancy = company.join("jobVacancy");

        List<Predicate> predicates = new ArrayList<>();

        //location
        if (filter.getLocation() != null && !filter.getLocation().isEmpty()) {
            predicates.add(cb.equal(company.get("location"), filter.getLocation()));
        }

        //cek job position berdasarkan array yg dikasi
        if (filter.getJobPosition() != null && !filter.getJobPosition().isEmpty()) {
            Predicate jobPositionPredicate = jobVacancy.get("jobPosition").in(filter.getJobPosition());
            predicates.add(jobPositionPredicate);
        }

        if (filter.getSearchKeyword() != null && !filter.getSearchKeyword().isEmpty()) {
            String searchPattern = "%" + filter.getSearchKeyword().toLowerCase() + "%";
            Predicate companyNamePredicate = cb.like(cb.lower(company.get("name")), searchPattern);
            Predicate companyDescriptionPredicate = cb.like(company.get("description"), searchPattern);

            predicates.add(cb.or(companyNamePredicate, companyDescriptionPredicate));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
