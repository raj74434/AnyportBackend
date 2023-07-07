package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepo userRepo;

    public UserDto createUser(UserDto userDto){
        User user=
    }

}
