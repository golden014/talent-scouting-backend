package org.enrichment.talent_scouting_backend.dao.company;

import jakarta.persistence.EntityManager;
import org.enrichment.talent_scouting_backend.model.Company;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        try {
            entityManager.persist(company);
            return company;
        } catch (Exception e) {
            // Log the exception (use a logging framework such as SLF4J)
            System.err.println("Error persisting company: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteCompany(int id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }

    @Override
    public List<Company> getAllCompanies() {
        Session session = entityManager.unwrap(Session.class);
        Query<Company> query = session.createQuery("from Company", Company.class);
        return query.getResultList();
    }
}
