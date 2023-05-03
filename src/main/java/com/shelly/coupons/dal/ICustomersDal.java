package com.shelly.coupons.dal;
import com.shelly.coupons.dto.CustomersDTO;
import com.shelly.coupons.entities.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICustomersDal extends CrudRepository<Customer, Long> {
@Query("SELECT new com.shelly.coupons.dto.CustomersDTO  " +
        "(u.id,u.userName,u.password,c.address,c.fullName,c.phoneNumber )" +
        "FROM User u INNER JOIN Customer c on u.id=c.id")
    List<CustomersDTO> getAllCustomers(Pageable pageable) ;

    @Query("SELECT new com.shelly.coupons.dto.CustomersDTO  " +
            "(u.id,u.userName,u.password,c.address,c.fullName,c.phoneNumber )" +
            "FROM User u INNER JOIN Customer c on u.id=c.id" +
            " WHERE u.id= :id")
    CustomersDTO getCustomer(long id) ;


}
