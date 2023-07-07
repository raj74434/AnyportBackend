package com.anyport.AnyPort.mappingInfo;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingInfo {

    @Autowired
    private ModelMapper modelMapper;

    public User userDto_to_user(UserDto dto){
        return modelMapper.map(dto, User.class);
    }

    public UserDto user_to_userDto(User user){
        return modelMapper.map(user, UserDto.class);
    }


}
