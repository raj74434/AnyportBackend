package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.service.UserService;
import com.anyport.AnyPort.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("/signup")
    private ResponseEntity<User> Signup(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/check")
    private ResponseEntity<String> check(){
        System.out.println("Recevied");
       return new ResponseEntity<>("it is ok",HttpStatus.ACCEPTED);
    }



}
