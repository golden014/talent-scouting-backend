package org.enrichment.talent_scouting_backend.service.company;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.enrichment.talent_scouting_backend.dao.company.CompanyDAO;
import org.enrichment.talent_scouting_backend.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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

    @Override
    @Transactional
    public List<Company> addCompanyBulk(MultipartFile file) throws IOException {
        List<Company> listCompany = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                //first row is a header
                if (row.getRowNum() == 0) {
                    continue;
                }
                Company company = new Company();
                company.setName(row.getCell(0).getStringCellValue());
                company.setLogoUrl(row.getCell(1).getStringCellValue());
                company.setDescription(row.getCell(2).getStringCellValue());
                company.setLocation(row.getCell(3).getStringCellValue());

                listCompany.add(company);
            }
        }

        return companyDAO.addCompanyBulk(listCompany);
    }
}
