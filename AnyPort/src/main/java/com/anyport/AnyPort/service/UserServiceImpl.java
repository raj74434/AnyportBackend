package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.mappingInfo.MappingInfo;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.OrdersRepo;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MappingInfo mapper;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private User userEntity;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createCustomerUser(UserDto userDto){
        User user=mapper.userDto_to_user(userDto);
        user.setUserType("Customer");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        This thing also work ==============================

//        userEntity.setGender(userDto.getGender());
//        userEntity.setName(userDto.getName());
//        =========================================================
        return userRepo.save(user);

    }

    @Override
    public List<Orders> oldOrders(Integer id){
        List<Orders> orders=ordersRepo.findByCustomerUser(id);
        return orders;
    }
    @Override
    public User getUserProfile(Integer id){
       User user= userRepo.findById(id).orElseThrow();
       if(user.getUserType().equals("Rider")){
           user.setOrder(user.getDriverOrders());
       }
       return user;
    }

}
