package com.faramatsi.crm.feedback;

import com.faramatsi.crm.customer.Customer;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
    @SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_seq", allocationSize = 1)
    private Long id;
    private String message;
    @ManyToOne@JoinColumn(name = "customer_id", nullable = false)

    private Customer customer;

    //Feedback Constructors
    public Feedback(){}
    public Feedback(String message, Customer customer) {
        this.message = message;
        this.customer = customer;
    }

    //Feedback Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
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
