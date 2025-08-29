package com.faramatsi.crm.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crm/customer/v1")
public class CustomerController {

    CustomerService service ;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }
}
