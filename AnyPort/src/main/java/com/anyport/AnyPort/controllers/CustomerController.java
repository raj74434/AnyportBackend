package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {

    private ResponseEntity<UserDto> Signup(@RequestBody UserDto userDto){



    }

}
