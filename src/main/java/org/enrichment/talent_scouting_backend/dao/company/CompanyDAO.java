package org.enrichment.talent_scouting_backend.dao.company;

import org.enrichment.talent_scouting_backend.model.Company;

import java.util.List;

public interface CompanyDAO {
    Company getCompany(int id);

    Company save(Company company);

    void deleteCompany(int id);

    List<Company> getAllCompanies();
}
