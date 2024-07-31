package org.enrichment.talent_scouting_backend.api.dao.company;

import org.enrichment.talent_scouting_backend.api.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @Override
    public Company getCompany(int id) {
        return null;
    }

    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public void deleteCompany(int id) {

    }

    @Override
    public List<Company> getAllCompanies() {
        return List.of();
    }

    @Override
    public List<Company> addCompanyBulk(List<Company> companies) {
        return List.of();
    }
}
