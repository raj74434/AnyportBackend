package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.service.UserService;
import com.anyport.AnyPort.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {
    @Autowired
    private UserService userService;

    private ResponseEntity<User> Signup(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

}
