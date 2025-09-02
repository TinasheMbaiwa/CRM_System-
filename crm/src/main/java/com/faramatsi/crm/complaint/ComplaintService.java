package com.faramatsi.crm.complaint;

import com.faramatsi.crm.customer.Customer;
import com.faramatsi.crm.customer.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Complaint> updateComplaint(Long id, Complaint complaint) {
       Optional<Complaint> complaint1 = repository.findById(id);
       if(complaint1.isEmpty())
       {
           return ResponseEntity.notFound().build();
       }else{
           Complaint DBComplaint = complaint1.get();
           DBComplaint.setMessage(complaint.getMessage());
           Complaint updatedComplaint = repository.save(DBComplaint);
           return ResponseEntity.ok(updatedComplaint);
       }
    }

    public ResponseEntity<Complaint> deleteComplaintById(Long id) {
        Optional<Complaint> complaint = repository.findById(id);

        if(complaint.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }else{
            repository.deleteById(complaint.get().getId());
            return ResponseEntity.ok(complaint.get());

        }

    }
}
