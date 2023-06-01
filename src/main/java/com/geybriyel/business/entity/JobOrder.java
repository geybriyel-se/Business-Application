package com.geybriyel.business.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "job_order")
public class JobOrder implements Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_order_number")
    private int jobNumber;

    @Column(name = "job_order_date")
    private Date jobDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "address")
    private String address;

}
