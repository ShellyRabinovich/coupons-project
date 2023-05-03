package com.shelly.coupons.controllers;

import com.shelly.coupons.dto.CompaniesDTO;
import com.shelly.coupons.entities.Company;
import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.logic.CompaniesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    private CompaniesLogic companiesLogic;

    @Autowired
    public CompaniesController(CompaniesLogic companiesLogic) {
        this.companiesLogic = companiesLogic;
    }


    @PostMapping
    public void createCompany(@RequestBody Company company) throws ServerException {
        this.companiesLogic.createCompany(company);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company) throws ServerException {
        this.companiesLogic.updateCompany(company);
    }

    @DeleteMapping("{companyId}")
    public void removeCompany(@PathVariable("companyId") int companyId) throws ServerException {
        this.companiesLogic.deleteCompany(companyId);
    }

    @GetMapping
    public List<CompaniesDTO> getAllCompanies(@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CompaniesDTO> companies =this.companiesLogic.getAllCompanies(pageNumber);
        return companies;
    }

    @GetMapping("{companyId}")
    public Company getCompany(@PathVariable("companyId") int companyId) throws ServerException {
        Company company = this.companiesLogic.getCompany(companyId);
        return company;
    }
}

