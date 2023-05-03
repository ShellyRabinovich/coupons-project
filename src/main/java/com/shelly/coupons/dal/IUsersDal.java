package com.shelly.coupons.dal;

import com.shelly.coupons.dto.UserData;
import com.shelly.coupons.dto.UsersDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.shelly.coupons.entities.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsersDal extends CrudRepository<User, Long> {
    @Query("SELECT new com.shelly.coupons.dto.UsersDTO" +
            "(u.id,u.userName,u.password,u.userType,u.company.name)" +
            " FROM User u LEFT JOIN Company co on u.company.id = co.id")
    List<UsersDTO> findAllUsers(Pageable pageable);

    @Query("SELECT new com.shelly.coupons.dto.UserData" +
            "(u.id,u.company.id,u.userType)" +
            "FROM User u WHERE u.userName= :name AND u.password= :password ")
    UserData logIn(@Param("name") String name, @Param("password") String password);

}


