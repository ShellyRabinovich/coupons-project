package com.shelly.coupons.logic;

import com.shelly.coupons.consts.Const;
import com.shelly.coupons.dal.IPurchasesDal;
import com.shelly.coupons.dto.CouponsPurchasesDTO;
import com.shelly.coupons.dto.CustomersPurchasesDTO;
import com.shelly.coupons.dto.PurchasesDTO;
import com.shelly.coupons.entities.Purchase;
import com.shelly.coupons.enums.ErrorType;
import com.shelly.coupons.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PurchasesLogic {
    @Autowired
    private IPurchasesDal purchasesDal;

    public long createPurchase(Purchase purchase) throws ServerException {
        // Validations
        try {
            purchasesDal.save(purchase);
            return purchase.getId();
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to create purchase. " + purchase.toString(), e);
        }
    }

    public void updatePurchase(Purchase purchase) throws ServerException {
        // Validations
        try {
            purchasesDal.save(purchase);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to update purchase. purchase id: " + purchase.getId(), e);
        }
    }

    public Purchase getPurchase(long id) throws ServerException {
        try {
            Purchase purchase = purchasesDal.findById(id).get();
            return purchase;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get purchase. purchase id: " + id, e);
        }

    }

    public void deletePurchase(long id) throws ServerException {
        try {
            purchasesDal.deleteById(id);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to remove purchase. purchase id: " + id, e);
        }
    }

    public List<PurchasesDTO> getAllPurchases(int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber - 1, Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<PurchasesDTO> purchases = purchasesDal.findAllPurchases(pageable);
            return purchases;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get all purchases", e);
        }
    }

    public List<CouponsPurchasesDTO> getAllPurchasesByCompanyId(int companyId, int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber - 1, Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<CouponsPurchasesDTO> purchasesByCompany = purchasesDal.findAllPurchasesByCompanyId(companyId, pageable);
            return purchasesByCompany;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get purchases by company id: " + companyId, e);
        }

    }

    public List<CustomersPurchasesDTO> getAllPurchasesByCustomerId(int customerId, int pageNumber) throws ServerException {
        Pageable pageable = PageRequest.of(pageNumber - 1, Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<CustomersPurchasesDTO> purchasesByCustomer = purchasesDal.findAllPurchasesByCustomerId(customerId, pageable);
            return purchasesByCustomer;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get purchases by customer id: " + customerId, e);
        }
    }
}

