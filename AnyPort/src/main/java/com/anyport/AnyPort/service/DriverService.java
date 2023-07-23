package com.anyport.AnyPort.service;

import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Orders;

import java.util.List;

public interface DriverService   {

    public List<Orders> catchOrder(Integer orderId, Integer userId);

    public List<ActiveOrders> getAllActiveOrders();

}
