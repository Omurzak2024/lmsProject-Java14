package peaksoft.lmsprojectjava14.service;

import peaksoft.lmsprojectjava14.entity.Company;

import java.util.List;

public interface CompanyService {

    void saveCompany(Company company);
    List<Company> getAllCompany();
    Company getCompanyById(Long id);
    void updateCompanyById(Long oldCompany,Company newCompany);
    void deleteCompanyById(Long id);


}
