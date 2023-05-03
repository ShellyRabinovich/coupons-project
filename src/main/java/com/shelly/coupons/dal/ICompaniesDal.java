package com.shelly.coupons.dal;

import com.shelly.coupons.dto.CompaniesDTO;
import com.shelly.coupons.entities.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICompaniesDal extends CrudRepository<Company, Long> {
    @Query("SELECT new com.shelly.coupons.dto.CompaniesDTO" +
            "(co.id,co.name,co.address,co.phoneNumber)" +
            "FROM Company co")
    List<CompaniesDTO> findAllCompanies(Pageable pageable);


}
