package com.anyport.AnyPort.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Background {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer backgroundId;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "verify")

    private User driverId;

    private LocalDate date;
    private String vehicle_type;
    private String vehicleNumber;
    private String adharcard;
    private String drivingLicenece;
    private boolean isVerified;


}
