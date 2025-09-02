package com.faramatsi.crm.feedback;

import com.faramatsi.crm.customer.Customer;
import com.faramatsi.crm.customer.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity< Feedback> updateFeedback(Long id, Feedback feedback) {

        Optional<Feedback> feedbackOptional = repository.findById(id);
        if(feedbackOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
              Feedback oldFeedback = feedbackOptional.get();
              oldFeedback.setMessage(feedback.getMessage());
              Feedback updatedFeedback = repository.save(oldFeedback);
              return ResponseEntity.ok(updatedFeedback);
         }
    }

    @Override
    public ResponseEntity<Feedback> deleteFeedbackById(Long id) {
        Optional<Feedback> feedback = repository.findById(id);
        if(feedback.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else {
            repository.delete(feedback.get());

            return ResponseEntity.ok(feedback.get());
        }
        }

}
