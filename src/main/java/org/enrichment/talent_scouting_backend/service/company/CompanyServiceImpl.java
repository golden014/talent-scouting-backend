package org.enrichment.talent_scouting_backend.service.company;

import org.enrichment.talent_scouting_backend.dao.company.CompanyDAO;
import org.enrichment.talent_scouting_backend.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    @Transactional
    public Company getCompany(int id) {
        return companyDAO.getCompany(id);
    }

    @Override
    @Transactional
    public Company save(Company company) {
        return companyDAO.save(company);
    }

    @Override
    @Transactional
    public void deleteCompany(int id) {
        companyDAO.deleteCompany(id);
    }

    @Override
    @Transactional
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }
}
