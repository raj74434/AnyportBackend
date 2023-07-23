package com.anyport.AnyPort.service;

import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.ActiveOrderRepo;
import com.anyport.AnyPort.repository.OrdersRepo;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements  DriverService {


    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private ActiveOrderRepo activeOrderRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Orders> catchOrder(Integer orderId, Integer userId){
        User user=userRepo.findById(userId).orElseThrow();
        if(user.getBackgroundVerify().isVerified()== false) throw new RuntimeException();

        ActiveOrders activeOrder=activeOrderRepo.findById(orderId).orElseThrow();
        Orders order=ordersRepo.findById(orderId).orElseThrow();

        activeOrderRepo.delete(activeOrder);
        order.setStatus("Asigned");
        order.setDriverUser(user);

        user.addOrder(ordersRepo.save(order));
        User savedUser =userRepo.save(user);
        return savedUser.getOrder();

    }


    @Override
    public List<ActiveOrders> getAllActiveOrders(){
        return activeOrderRepo.findAll();
    }

}
