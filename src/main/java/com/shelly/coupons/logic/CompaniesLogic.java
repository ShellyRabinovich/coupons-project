package com.shelly.coupons.logic;

import com.shelly.coupons.consts.Const;
import com.shelly.coupons.dal.ICompaniesDal;
import com.shelly.coupons.dto.CompaniesDTO;
import com.shelly.coupons.entities.Company;
import com.shelly.coupons.enums.ErrorType;
import com.shelly.coupons.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompaniesLogic {
    @Autowired
    private ICompaniesDal companiesDal;

    public long createCompany(Company company) throws ServerException {
        // Validations
        try {
            companiesDal.save(company);
            return company.getId();
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "failed to create company" + company.toString(), e);
        }
    }

    public void updateCompany(Company company) throws ServerException {
        // Validations
        try {
            companiesDal.save(company);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to update company. company id: " + company.getId(), e);
        }
    }

    public Company getCompany(long id) throws ServerException {
        try {
            Company company = companiesDal.findById(id).get();
            return company;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get company. company id: " + id, e);
        }
    }

    public void deleteCompany(long id) throws ServerException {
        try {
            companiesDal.deleteById(id);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to remove company. company id: " + id, e);
        }

    }

    public List<CompaniesDTO> getAllCompanies(int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber - 1, Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<CompaniesDTO> companies = companiesDal.findAllCompanies(pageable);
            return companies;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get all companies", e);
        }
    }
}

