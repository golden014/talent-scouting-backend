package org.enrichment.talent_scouting_backend.api.controller;

import org.enrichment.talent_scouting_backend.api.model.Company;
import org.enrichment.talent_scouting_backend.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/deleteCompanyById")
    public void deleteCompanyById(int id) {
        companyService.deleteCompany(id);
    }

    @PostMapping("/insertCompanyBulk")
    public List<Company> insertCompanyBulk(@RequestParam("file") MultipartFile file) {
        System.out.println("masuk");
        try {
            return companyService.addCompanyBulk(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
