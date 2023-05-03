package com.shelly.coupons.logic;


import com.shelly.coupons.consts.Const;
import com.shelly.coupons.dal.ICustomersDal;
import com.shelly.coupons.dto.CustomersDTO;
import com.shelly.coupons.entities.Customer;
import com.shelly.coupons.enums.ErrorType;
import com.shelly.coupons.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomersLogic {

    @Autowired
    private ICustomersDal customersDal;

    public long createCustomer(Customer customer) throws ServerException {
        // Validations
        try {
            customersDal.save(customer);
            return customer.getUser().getId();}
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to create customer. "+customer.toString(),e);
        }

    }

    public void updateCustomer(Customer customer) throws ServerException {
        // Validations
        try {
            customersDal.save(customer);
        }
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to update customer. customer id: "+customer.getUser().getId(),e);
        }
    }

    public CustomersDTO getCustomer(long id) throws ServerException {
        try {
            CustomersDTO customer = customersDal.getCustomer(id);
            return customer;
        }
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to get customer. customer id: "+id,e);
        }

    }
    public List<CustomersDTO> getAllCustomers(int pageNumber) throws ServerException {
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<CustomersDTO> customers=customersDal.getAllCustomers(pageable);
            return customers;
        }
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to get all customers",e);
        }
    }

    public void deleteCustomer(long id) throws ServerException {
        try {
            customersDal.deleteById(id);
        }
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to remove customer. customer id: "+id,e);
        }
    }

//    public List<User> getAllUsersByName(String name){
//        List<User> users= customersDal.findUsersByName(name);
//        return users;
//    }

}


