package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.mappingInfo.MappingInfo;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MappingInfo mapper;
    @Autowired
    private UserRepo userRepo;

    public User createUser(UserDto userDto){
        User user=mapper.userDto_to_user(userDto);
        return  user;
    }

}
