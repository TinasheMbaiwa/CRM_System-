package com.faramatsi.crm.customer;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "cust_sequence",
            sequenceName = "cust_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cust_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber ;
    private String address;
    LocalDate dateOfBirth;
    List<String> complaints;
    List<String> feedbacks;

    //Customer constructors


    public Customer() {

    }

    public Customer(String firstName, String lastName,
                    String email, String phoneNumber,
                    String address, LocalDate dateOfBirth,
                    List<String> complaints, List<String> feedbacks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.complaints = complaints;
        this.feedbacks = feedbacks;
    }
    //Testing Constructor
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Customer Getters and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<String> complaints) {
        this.complaints = complaints;
    }

    public List<String> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<String> feedbacks) {
        this.feedbacks = feedbacks;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", complaints=" + complaints +
                ", feedbacks=" + feedbacks +
                '}';
    }
}
