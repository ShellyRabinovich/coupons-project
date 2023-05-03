package com.shelly.coupons.controllers;

import com.shelly.coupons.dto.CustomersDTO;
import com.shelly.coupons.entities.Customer;
import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.logic.CustomersLogic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    private CustomersLogic customersLogic;

    public CustomersController(CustomersLogic customersLogic) {
        this.customersLogic = customersLogic;
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) throws ServerException {
    this.customersLogic.createCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) throws ServerException {
        this.customersLogic.updateCustomer(customer);
    }

    @DeleteMapping("{customerId}")
    public void removeCustomer(@PathVariable("customerId") int customerId) throws ServerException {
        this.customersLogic.deleteCustomer(customerId);
    }

    @GetMapping
    public List<CustomersDTO> getAllCustomers(@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<CustomersDTO> customers= this.customersLogic.getAllCustomers(pageNumber);
        return customers;
    }

    @GetMapping("{customerId}")
    public CustomersDTO getCustomer(@PathVariable("customerId") int customerId) throws ServerException {
        CustomersDTO customer = this.customersLogic.getCustomer(customerId);
        return customer;
    }
}



