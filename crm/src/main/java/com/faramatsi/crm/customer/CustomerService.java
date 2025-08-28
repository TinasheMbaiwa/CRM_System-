package com.faramatsi.crm.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
       CustomerRepository repository;


    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getCustomers(){
        return repository.findAll();
    }
}
