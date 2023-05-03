package com.shelly.coupons.controllers;

import com.shelly.coupons.dto.UserLoginData;
import com.shelly.coupons.dto.UsersDTO;
import com.shelly.coupons.entities.User;
import com.shelly.coupons.exceptions.ServerException;
import com.shelly.coupons.logic.UsersLogic;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersLogic usersLogic;

    public UsersController(UsersLogic usersLogic) {
        this.usersLogic = usersLogic;
    }

    @PostMapping
    public void createUser(@RequestBody User user) throws ServerException {
        this.usersLogic.createUser(user);
    }
    @PostMapping("/login")
    public String logIn(@RequestBody UserLoginData userLoginData) throws ServerException{
        String token=this.usersLogic.logIn(userLoginData);
        return token;
    }

    @PutMapping
    public void updateUser(@RequestBody User user) throws ServerException {
        this.usersLogic.updateUser(user);
    }

    @DeleteMapping("{userId}")
    public void removeUser(@PathVariable("userId") int userId) throws ServerException {
        this.usersLogic.deleteUser(userId);
    }

    @GetMapping
    public List<UsersDTO> getAllUsersPageByPage(@RequestParam("pageNumber") int pageNumber) throws ServerException {
        List<UsersDTO> users = this.usersLogic.getAllUsers(pageNumber);
        return users;
    }

    @GetMapping("{userId}")
    public User getUser(@PathVariable("userId") int userId) throws ServerException {
        User user = this.usersLogic.getUser(userId);
        return user;
    }
}

