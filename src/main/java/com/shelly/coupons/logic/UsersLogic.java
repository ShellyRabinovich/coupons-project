package com.shelly.coupons.logic;


import com.shelly.coupons.consts.Const;
import com.shelly.coupons.dto.UserData;
import com.shelly.coupons.dto.UserLoginData;
import com.shelly.coupons.dto.UsersDTO;
import com.shelly.coupons.entities.User;
import com.shelly.coupons.enums.ErrorType;
import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.shelly.coupons.dal.IUsersDal;

import java.util.List;

@Controller
public class UsersLogic {

    @Autowired
    private IUsersDal usersDal;

    public long createUser(User user) throws ServerException {
        // Validations
       try {
           usersDal.save(user);
           return user.getId();
       }
       catch (Exception e){
           throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to create user"+user.toString(),e);
       }
    }

    public void updateUser(User user) throws ServerException {
        // Validations
        try {
            usersDal.save(user);
        }
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to update user. user id: "+user.getId(),e);
        }
    }

    public User getUser(long id) throws ServerException {
        try {
            User user = usersDal.findById(id).get();
            return user;}
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to get user. id: "+id,e);
        }

    }
    public List<UsersDTO> getAllUsers(int pageNumber) throws ServerException {
        Pageable pageable= PageRequest.of(pageNumber-1,Const.AMOUNT_OF_ITEMS_PER_PAGE);
        try {
            List<UsersDTO> users = usersDal.findAllUsers(pageable);
            return users;
        }
        catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to get all users",e);
        }

    }
    public String logIn(UserLoginData userLoginData) throws ServerException {
        // mocking a successfull login
        try {
            UserData userData = usersDal.logIn(userLoginData.getUserName(), userLoginData.getPassword());
            if (userData == null) {
                throw new Exception("Failed to login");
            }
            String token = JWTUtils.createJWT(userData);
            return token;
        } catch (Exception e){
            throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to login"+ userLoginData.toString(),e);
        }
    }

    public void deleteUser(long id) throws ServerException {
       try {
           usersDal.deleteById(id);
       }
       catch (Exception e){
           throw new ServerException(ErrorType.GENERAL_ERROR,"Failed to remove user id: "+id,e);
       }
    }


}
