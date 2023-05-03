package com.shelly.coupons.controllers;

import com.shelly.coupons.dto.CouponsDTO;
import com.shelly.coupons.dto.LimitedInfoCouponDTO;
import com.shelly.coupons.entities.Coupon;
import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.logic.CouponsLogic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

    private CouponsLogic couponsLogic;

    public CouponsController(CouponsLogic couponsLogic) {
        this.couponsLogic = couponsLogic;
    }

    @PostMapping
    public void createCoupon(@RequestBody Coupon coupon) throws ServerException {
       this.couponsLogic.createCoupon(coupon);
    }

    @PutMapping
    public void updateCoupon(@RequestBody Coupon coupon) throws ServerException {
        this.couponsLogic.updateCoupon(coupon);
    }

    @DeleteMapping("{couponId}")
    public void removeCoupon(@PathVariable("couponId") int couponId) throws ServerException {
        this.couponsLogic.deleteCoupon(couponId);
    }
//   @DeleteMapping
//    public void removeAllCouponsOfCompany(int companyId) throws ServerException {
//        this.couponsLogic.removeAllCouponsOfCompany(companyId);
//    }


    @GetMapping
    public List<CouponsDTO> getAllCouponsPageByPage(@RequestParam("pageNumber") int pageNumber, @RequestParam("amountPerPage") int amountPerPage) throws ServerException {
        List<CouponsDTO> coupons = this.couponsLogic.getAllCoupons(pageNumber);
        return coupons;
    }
    @GetMapping("/limited")
    public List<LimitedInfoCouponDTO> getAllCouponsWithLimitedInfo(@RequestParam("pageNumber") int pageNumber, @RequestParam("amountPerPage") int amountPerPage) throws ServerException {
        List<LimitedInfoCouponDTO> coupons = this.couponsLogic.findAllCouponsWithLimitedInfo(pageNumber);
        return coupons;
    }



    @GetMapping("/limitedById")
    public LimitedInfoCouponDTO getCouponWithLimitedInfo(@RequestParam("couponId") int couponId) throws ServerException {
        LimitedInfoCouponDTO coupon = this.couponsLogic.findCouponWithLimitedInfo(couponId);
        return coupon;
    }
    @GetMapping("{couponId}")
    public CouponsDTO getCoupon(@PathVariable("couponId") int couponId) throws ServerException {
        CouponsDTO coupon = this.couponsLogic.getCoupon(couponId);
        return coupon;
    }
    @GetMapping("/categoryId")
    public List<CouponsDTO>getAllCouponsByCategoryIdPageByPage (@PathVariable("categoryId") int categoryId,@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CouponsDTO> couponsByCategory = couponsLogic.getCouponsByCategoryId( categoryId, pageNumber);
        return couponsByCategory;
    }
    @GetMapping("/byPriceRange")
    public List<CouponsDTO> getCouponsByPriceRange(@PathVariable("minPrice") int minPrice,@PathVariable("maxPrice") int maxPrice,@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CouponsDTO> couponsByPriceRange = couponsLogic.getCouponsByPriceRange(minPrice, maxPrice, pageNumber);
        return couponsByPriceRange;
    }
}

