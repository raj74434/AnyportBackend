package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.User;

public interface UserService {

    public User createUser(UserDto userDto);

}
