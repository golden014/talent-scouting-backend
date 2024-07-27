package org.enrichment.talent_scouting_backend.service.company;

import org.enrichment.talent_scouting_backend.model.Company;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CompanyService {
    Company getCompany(int id);

    Company save(Company company);

    void deleteCompany(int id);

    List<Company> getAllCompanies();

    List<Company> addCompanyBulk(MultipartFile file) throws IOException;
}
