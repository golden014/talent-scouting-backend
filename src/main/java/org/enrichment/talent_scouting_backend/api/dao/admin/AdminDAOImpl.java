package org.enrichment.talent_scouting_backend.api.dao.admin;

import jakarta.persistence.EntityManager;
import org.enrichment.talent_scouting_backend.api.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private EntityManager em;

    @Override
    public List<Admin> get() {
        return em.createQuery("from Admin", Admin.class).getResultList();
    }

    @Override
    public Admin get(int id) {
        return em.find(Admin.class, id);
    }

    @Override
    public Admin get(String username, String password) {
        String jpql = "SELECT a FROM Admin a WHERE a.name = :username AND a.password = :password";
        return em.createQuery(jpql, Admin.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }

    @Override
    public Admin save(Admin admin) {
        em.persist(admin);
        return admin;
    }

}
