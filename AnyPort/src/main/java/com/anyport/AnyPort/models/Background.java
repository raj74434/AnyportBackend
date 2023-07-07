package com.anyport.AnyPort.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

public class Background {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer backgroundId;
    @OneToOne
    private User driverId;
    private LocalDate date;
    private String vehicle_type;
    private String vehicleNumber;
    private String adharcard;
    private String drivingLicenece;


}
