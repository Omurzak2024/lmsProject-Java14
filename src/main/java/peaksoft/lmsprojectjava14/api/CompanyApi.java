package peaksoft.lmsprojectjava14.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.lmsprojectjava14.entity.Company;
import peaksoft.lmsprojectjava14.exception.MyException;
import peaksoft.lmsprojectjava14.service.CompanyService;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyApi {

    private final CompanyService companyService;

    @GetMapping("/new")
    public String createCompany(Model model){
        model.addAttribute("newCompany",new Company());
        return "/company/newCompany";
    }

    @PostMapping("/newCompany")
    public String saveCompany(@ModelAttribute("newCompany") Company company){
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping
    public String getAllCompanies(Model model){
        model.addAttribute("companies",companyService.getAllCompany());
        return "company/companyMainPage";
    }

    @PostMapping("/update/{companyId}")
    public String updateCompany(@PathVariable("companyId") Long companyId,
                                @ModelAttribute("company") Company company) throws MyException{
        companyService.updateCompanyById(companyId, company);
        return "redirect:/companies";
    }

    @PostMapping("/{companyId}/delete")
    public String delete(@PathVariable Long companyId){
        companyService.deleteCompanyById(companyId);
        return "redirect:/companies";
    }

}
