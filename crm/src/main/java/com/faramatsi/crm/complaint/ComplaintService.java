package com.faramatsi.crm.complaint;

import com.faramatsi.crm.customer.Customer;
import com.faramatsi.crm.customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    ComplaintRepository repository;
    CustomerRepository customerRepository;

    public ComplaintService(ComplaintRepository repository ,CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    public List<Complaint> getAllComplaints(){
       return repository.findAll();
    }

    public void addComplaint(Complaint complaint) {
        Customer cust = customerRepository.findById(complaint.getCustomerId()).orElseThrow(()->new IllegalStateException("Customer not Found"));

        if(cust!=null){
            complaint.setCustomer(cust);
        }

        repository.save(complaint);

    }
}
