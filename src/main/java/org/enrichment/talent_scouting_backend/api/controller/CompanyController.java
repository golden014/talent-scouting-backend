package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.model.Company;
import org.enrichment.talent_scouting_backend.api.request.CompanyFilter;
import org.enrichment.talent_scouting_backend.api.request.CompanyLogin;
import org.enrichment.talent_scouting_backend.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/get")
    public Company getCompanyById(int id) {
        return companyService.getCompany(id);
    }

    @GetMapping("/getAll")
    public List<Company> getAllCompany() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/save")
    public Company insertCompany(Company company) {
        return companyService.save(company);
    }

    @PostMapping("/delete")
    public void deleteCompanyById(int id) {
        companyService.deleteCompany(id);
    }

    @PostMapping("/saveBulk")
    public List<Company> insertCompanyBulk(@RequestParam("file") MultipartFile file) {
        System.out.println("masuk");
        try {
            return companyService.addCompanyBulk(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/loginCompany")
    public Company loginCompany(@RequestBody CompanyLogin companyLogin) {
        System.out.println(companyLogin.getEmail() + " " + companyLogin.getPassword());
        return companyService.authenticate(companyLogin.getEmail(), companyLogin.getPassword());
    }

    @PostMapping("/getCompanyByFilter")
    public List<Company> getCompanyByFilter(@RequestBody CompanyFilter companyFilter) {
        return companyService.getCompanyByFilter(companyFilter);
    }
}
