package com.shelly.coupons.dal;

import com.shelly.coupons.dto.CouponsPurchasesDTO;
import com.shelly.coupons.dto.CustomersPurchasesDTO;
import com.shelly.coupons.dto.PurchasesDTO;
import com.shelly.coupons.entities.Purchase;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchasesDal extends CrudRepository<Purchase, Long> {
    @Query("SELECT new com.shelly.coupons.dto.PurchasesDTO" +
      "(pu.id,pu.coupon.name,pu.customer.fullName,pu.amount,pu.timestamp)" +
            "FROM Purchase pu JOIN Coupon cou on pu.coupon.id=cou.id JOIN " +
            "Customer cu on pu.customer.id=cu.user.id")
    List<PurchasesDTO> findAllPurchases (Pageable pageable);

    @Query("SELECT new com.shelly.coupons.dto.CouponsPurchasesDTO" +
            "(pu.id,pu.coupon.name,pu.coupon.price,pu.timestamp,pu.amount,pu.customer.fullName,pu.customer.address,pu.customer.phoneNumber)" +
            " FROM Purchase pu JOIN Coupon cou on pu.coupon.id=cou.id JOIN " +
            "Customer cu on pu.customer.id=cu.user.id " +
            "WHERE cou.company.id= :companyId")
    List<CouponsPurchasesDTO> findAllPurchasesByCompanyId (@Param("companyId") int companyId, Pageable pageable);

    @Query("SELECT new com.shelly.coupons.dto.CustomersPurchasesDTO" +
            "(pu.id,pu.coupon.name,pu.coupon.price,pu.timestamp,pu.amount )" +
            "FROM Purchase pu JOIN Customer cu on pu.customer.id=cu.user.id JOIN " +
            " Coupon cou on pu.coupon.id=cou.id " +
            "WHERE cu.id= :customerId ")
    List<CustomersPurchasesDTO> findAllPurchasesByCustomerId (@Param("customerId") int customerId, Pageable pageable);

}
