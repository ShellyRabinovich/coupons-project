package com.shelly.coupons.controllers;

import com.shelly.coupons.dto.CouponsPurchasesDTO;
import com.shelly.coupons.dto.CustomersPurchasesDTO;
import com.shelly.coupons.dto.PurchasesDTO;
import com.shelly.coupons.entities.Purchase;
import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.logic.PurchasesLogic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
    private PurchasesLogic purchasesLogic;

    public PurchasesController(PurchasesLogic purchasesLogic) {
        this.purchasesLogic = purchasesLogic;
    }

    @PostMapping
    public void createPurchase(@RequestBody Purchase purchase) throws ServerException {
        this.purchasesLogic.createPurchase(purchase);
    }

    @PutMapping
    public void updatePurchase(@RequestBody Purchase purchase) throws ServerException {
        this.purchasesLogic.updatePurchase(purchase);
    }

    @DeleteMapping("{purchaseId}")
    public void removeCoupon(@PathVariable("purchaseId") int purchaseId) throws ServerException {
        this.purchasesLogic.deletePurchase(purchaseId);
    }

    @GetMapping
    public List<PurchasesDTO> getAllPurchasesPageByPage(@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<PurchasesDTO> purchases = this.purchasesLogic.getAllPurchases(pageNumber);
        return purchases;
    }

    @GetMapping("/companyId")
    public List<CouponsPurchasesDTO> getAllPurchasesByCompanyId(@RequestParam("companyId") int companyId, @RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CouponsPurchasesDTO> purchasesByCompany = this.purchasesLogic.getAllPurchasesByCompanyId(companyId, pageNumber);
        return purchasesByCompany;
    }
    @GetMapping("/customerId")
    public List<CustomersPurchasesDTO> getAllPurchasesByCustomerId(@RequestParam("customerId") int customerId, @RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CustomersPurchasesDTO> purchasesByCustomer = this.purchasesLogic.getAllPurchasesByCustomerId(customerId, pageNumber);
        return purchasesByCustomer;
    }

    @GetMapping("{purchaseId}")
    public Purchase getPurchase(@PathVariable("purchaseId") int purchaseId) throws ServerException {
        Purchase purchase = this.purchasesLogic.getPurchase(purchaseId);
        return purchase;
    }
}
