package com.faramatsi.crm.complaint;

import com.faramatsi.crm.customer.Customer;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Complaint {
    @Id
    @SequenceGenerator(
            name = "complaint_seq",
            sequenceName = "complaint_seq",
            allocationSize = 1
    )
    @GeneratedValue(
           strategy = GenerationType.SEQUENCE,generator = "complaint_seq"
    )
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Transient
    private Long customerId;

    //Complaint Constructors

    public Complaint(){}

    public Complaint(String message, Customer customer) {
        this.message = message;
        this.customer = customer;
    }

    public Complaint(String message, Long customerId) {
        this.message = message;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
