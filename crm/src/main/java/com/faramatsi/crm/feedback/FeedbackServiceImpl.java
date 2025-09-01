package com.faramatsi.crm.feedback;

import com.faramatsi.crm.customer.Customer;
import com.faramatsi.crm.customer.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService{

        FeedbackRepository repository;
        CustomerRepository customerRepository;

    public FeedbackServiceImpl(FeedbackRepository repository,CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository =customerRepository;
    }

    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void addFeedback(Feedback feedback) {
        if(feedback !=null && feedback.getCustomer()!=null){
            Long customerId = feedback.getCustomer().getId();
            if(customerId!=null){
                Customer cust = customerRepository.findById(customerId).orElseThrow(()->new IllegalStateException("Customer not in DB"));
                feedback.setCustomer(cust);
                repository.save(feedback);
            }else {
                throw new IllegalStateException("Invalid Customer ID");
            }

        }
        else {
            throw new IllegalStateException("Either the feedback or customer in invalid");
        }

    }
}
