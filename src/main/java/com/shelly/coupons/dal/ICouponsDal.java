package com.shelly.coupons.dal;


import com.shelly.coupons.dto.CouponsDTO;
import com.shelly.coupons.dto.LimitedInfoCouponDTO;
import com.shelly.coupons.entities.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ICouponsDal extends CrudRepository<Coupon, Long> {

    @Query("SELECT new com.shelly.coupons.dto.CouponsDTO(cou.id, cou.name, cou.price, cou.description, cou.startDate, cou.endDate, cou.category.name, cou.company.name) " +
            "FROM Coupon cou JOIN Category cat ON cou.category.id = cat.id " +
            "JOIN Company com ON cou.company.id = com.id WHERE cou.id= :id")
    CouponsDTO findCouponById(@Param("id") long id);

    @Query("SELECT new com.shelly.coupons.dto.CouponsDTO(cou.id, cou.name, cou.price, cou.description, cou.startDate, cou.endDate, cou.category.name, cou.company.name) " +
            "FROM Coupon cou JOIN Category cat ON cou.category.id = cat.id " +
            "JOIN Company com ON cou.company.id = com.id")
    List<CouponsDTO> findAllCoupons(Pageable pageable);

    @Query("SELECT new com.shelly.coupons.dto.LimitedInfoCouponDTO(cou.name, cou.price, cou.description, cou.endDate, cou.id) " +
            "FROM Coupon cou ")
    List<LimitedInfoCouponDTO> findAllCouponsWithLimitedInfo(Pageable pageable);

    @Query("SELECT new com.shelly.coupons.dto.LimitedInfoCouponDTO(cou.name, cou.price, cou.description, cou.endDate, cou.id) " +
            "FROM Coupon cou WHERE cou.id= :id ")
    LimitedInfoCouponDTO findCouponWithLimitedInfo(@Param("id") long id);

    @Transactional
    void deleteByEndDateBefore(@Param("endDate") Date endDate);

    @Query("SELECT new com.shelly.coupons.dto.CouponsDTO"+
    "(cou.id,cou.name,cou.price,cou.description,cou.startDate,cou.endDate,ca.name,co.name)"
    +"FROM Coupon cou INNER JOIN Company co on cou.company.id=co.id INNER JOIN "+
    "Category ca on cou.category.id=ca.id WHERE price BETWEEN :minPrice AND :maxPrice")
    List<CouponsDTO> findCouponsByPriceRange(@Param("minPrice") int minPrice, @Param("maxPrice")int maxPrice,Pageable pageable);

    @Query("SELECT new com.shelly.coupons.dto.CouponsDTO"+
            "(cou.id,cou.name,cou.price,cou.description,cou.startDate,cou.endDate,ca.name,co.name)"
            +"FROM Coupon cou INNER JOIN Company co on cou.company.id=co.id INNER JOIN "+
            "Category ca on cou.category.id=ca.id WHERE ca.id= :categoryId")
    List<CouponsDTO> findCouponsByCategoryId(@Param("categoryId") int categoryId, Pageable pageable);
}


