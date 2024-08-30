package org.enrichment.talent_scouting_backend.api.dao.company;

import org.enrichment.talent_scouting_backend.api.model.Company;

import java.util.List;

public interface CompanyDAO {
    Company getCompany(int id);

    Company save(Company company);

    void deleteCompany(int id);

    List<Company> getAllCompanies();

    List<Company> addCompanyBulk(List<Company> companies);

    Company authenticate(String username, String password);
}
