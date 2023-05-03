package com.shelly.coupons.logic;

import com.shelly.coupons.consts.Const;
import com.shelly.coupons.dal.ICouponsDal;
import com.shelly.coupons.dto.CouponsDTO;
import com.shelly.coupons.dto.LimitedInfoCouponDTO;
import com.shelly.coupons.entities.Coupon;
import com.shelly.coupons.enums.ErrorType;
import com.shelly.coupons.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class CouponsLogic {
    @Autowired
    private ICouponsDal couponsDal;

    public long createCoupon(Coupon coupon) throws ServerException {
        // Validations
        try {
            couponsDal.save(coupon);
            return coupon.getId();
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to create coupon. " + coupon.toString(), e);
        }
    }

    public void updateCoupon(Coupon coupon) throws ServerException {
        // Validations
        try {
            couponsDal.save(coupon);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to update coupon. coupon id: " + coupon.getId(), e);
        }
    }

    public CouponsDTO getCoupon(long id) throws ServerException {
        try {
            CouponsDTO coupon = couponsDal.findCouponById(id);
            return coupon;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get coupon. coupon id: " + id, e);
        }
    }
    public LimitedInfoCouponDTO findCouponWithLimitedInfo(long id) throws ServerException {
        try {
            LimitedInfoCouponDTO coupon = couponsDal.findCouponWithLimitedInfo(id);
            return coupon;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get coupon. coupon id: " + id, e);
        }
    }

    public void deleteCoupon(long id) throws ServerException {
        try {
            couponsDal.deleteById(id);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to remove coupon. coupon id: " + id, e);
        }
    }



    public List<LimitedInfoCouponDTO> findAllCouponsWithLimitedInfo(int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber - 1, Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<LimitedInfoCouponDTO> coupons = couponsDal.findAllCouponsWithLimitedInfo(pageable);
            return coupons;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get all limited info coupons", e);
        }
    }

    public List<CouponsDTO> getAllCoupons(int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber-1 , Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<CouponsDTO> coupons = couponsDal.findAllCoupons(pageable);
            return coupons;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get all coupons", e);
        }
    }

    public void removeExpiredCoupons(Date date) throws ServerException {
        try {
            couponsDal.deleteByEndDateBefore(date);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to delete expired coupons. time: " + Calendar.getInstance(), e);
        }
    }

    public List<CouponsDTO> getCouponsByPriceRange(int minPrice, int maxPrice, int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber - 1, Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<CouponsDTO> coupons = couponsDal.findCouponsByPriceRange(minPrice, maxPrice, pageable);
            return coupons;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get coupons by price range. min price: " + minPrice + ". max price: " + maxPrice, e);
        }

    }

    public List<CouponsDTO> getCouponsByCategoryId(int categoryId, int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber - 1, Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<CouponsDTO> coupons = couponsDal.findCouponsByCategoryId(categoryId, pageable);
            return coupons;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get coupons by category id. category id: " + categoryId, e);
        }
    }

}

