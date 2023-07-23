package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.service.DriverService;
import com.anyport.AnyPort.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/drive")
public class DriverController {

    private DriverService driverService;

    @CrossOrigin
    @GetMapping("/activeOrders")
    public ResponseEntity<List<ActiveOrders>> getAllActiveOrders(){
        return new ResponseEntity<>(driverService.getAllActiveOrders(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/catchOrder")
    public ResponseEntity<List<Orders>> catchOrder(Integer orderId,Integer userId){
        return new ResponseEntity<>(driverService.catchOrder(orderId,userId), HttpStatus.OK);
    }

}
