package peaksoft.lmsprojectjava14.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.repository.CompanyRepository;
import peaksoft.lmsprojectjava14.service.CompanyService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException(
                        "Company with id" + id + "not found"
                )
        );
    }

    @Override
    public void updateCompanyById(Long oldCompany, Company newCompany) {
        Company company = getCompanyById(oldCompany);
        company.setName(newCompany.getName());
        company.setCountry(newCompany.getCountry());
        company.setAddress(newCompany.getAddress());
        company.setPhoneNumber(newCompany.getPhoneNumber());
        companyRepository.save(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        if (companyRepository.existsById(id)){
            companyRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Company with id" + id + "not found"
            );
        }
        companyRepository.deleteById(id);

    }
}
