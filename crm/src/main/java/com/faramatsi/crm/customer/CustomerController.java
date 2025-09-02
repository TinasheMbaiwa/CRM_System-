package com.faramatsi.crm.customer;

import org.springframework.http.ResponseEntity;
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

    @PutMapping("update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer CustDetails)
    {
       return service.updateCustomer( id, CustDetails);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable Long id)
    {
        return service.deleteCustomerById(id);
    }
}
