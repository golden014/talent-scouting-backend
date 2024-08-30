package org.enrichment.talent_scouting_backend.api.dao.company;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.enrichment.talent_scouting_backend.api.model.Company;
import org.enrichment.talent_scouting_backend.api.model.Student;
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
}
