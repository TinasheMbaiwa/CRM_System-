package com.faramatsi.crm.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crm/customers/v1")
public class CustomerController {

    CustomerService service ;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return service.getCustomers();
    }

    @PostMapping("add/")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }
}
