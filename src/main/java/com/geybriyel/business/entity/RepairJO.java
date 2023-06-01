package com.geybriyel.business.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "job_order")
public class RepairJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_order_number")
    private int jobNumber;

    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public RepairJO() {
    }

    public RepairJO(Date jobDate, String firstName, String lastName, String phoneNumber, String telephoneNumber, String address) {
        this.jobDate = jobDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public RepairJO(String firstName, String lastName, String phoneNumber, String telephoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "-- Job Order--" +
                "\nJob Order Number: " + jobNumber +
                "\nJob Order Date: " + jobDate +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nPhone Number: " + phoneNumber +
                "\nTelephone Number: " + telephoneNumber +
                "\nAddress" + address;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
