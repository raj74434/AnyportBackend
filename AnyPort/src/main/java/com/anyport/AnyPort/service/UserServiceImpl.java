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

    @Autowired
    private User userEntity;
    public User createUser(UserDto userDto){
        User user=mapper.userDto_to_user(userDto);

//        This thing also work ==============================

//        userEntity.setGender(userDto.getGender());
//        userEntity.setName(userDto.getName());
//        =========================================================
        return userRepo.save(user);

    }

}
