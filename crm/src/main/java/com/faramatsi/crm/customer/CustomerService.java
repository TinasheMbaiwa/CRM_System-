package com.faramatsi.crm.customer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
       CustomerRepository repository;


    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getCustomers(){
        return repository.findAll();
    }

    public void addCustomer(Customer customer) {
        repository.save(customer);

    }
    public ResponseEntity<Customer> updateCustomer(Long id, Customer customer)
    {
        Optional<Customer> cust = repository.findById(id);
        if(cust.isEmpty())
        {
                return ResponseEntity.notFound().build();
        }else{
                Customer DBCustomer = cust.get();
                DBCustomer.setFirstName(customer.getFirstName());
                DBCustomer.setLastName(customer.getLastName());

                Customer UpdatedCustomer = repository.save(DBCustomer);

                return ResponseEntity.ok(UpdatedCustomer);
        }
    }

    public ResponseEntity<Customer> deleteCustomerById(Long id) {

        Optional<Customer> cust = repository.findById(id);
        if(cust.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            repository.deleteById(id);
            return ResponseEntity.ok(cust.get());
        }

    }
}
