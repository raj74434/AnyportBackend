package com.anyport.AnyPort.models;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @OneToOne
    private User customerUser;
    @OneToOne
    private User driverUser;

    private Integer price;
    private Integer payment_method;
    private String pickupAddress;
    private String dropAddress;
    private String status;


}
