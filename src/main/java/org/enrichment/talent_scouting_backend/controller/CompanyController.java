package org.enrichment.talent_scouting_backend.controller;

import org.enrichment.talent_scouting_backend.model.Company;
import org.enrichment.talent_scouting_backend.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/getCompanyById")
    public Company getCompanyById(int id) {
        return companyService.getCompany(id);
    }

    @GetMapping("/getAllCompany")
    public List<Company> getAllCompany() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/insertCompany")
    public Company insertCompany(Company company) {
        return companyService.save(company);
    }

    @PostMapping("deleteCompanyById")
    public void deleteCompanyById(int id) {
        companyService.deleteCompany(id);
    }
}
