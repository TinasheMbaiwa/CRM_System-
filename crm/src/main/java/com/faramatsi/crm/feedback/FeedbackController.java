package com.faramatsi.crm.feedback;

import com.faramatsi.crm.customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crm/feedbacks/v1")
public class FeedbackController {

    private FeedbackServiceImpl service;

    public FeedbackController(FeedbackServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks(){
        return service.getAllFeedback();
    }

    @PostMapping("add/")
    public void addFeedback(@RequestBody Feedback feedback){
        service.addFeedback(feedback);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback){
        return service.updateFeedback(id,feedback);
    }
    @DeleteMapping("remove/{id}")
    public ResponseEntity<Feedback> deleteFeedbackById(@PathVariable Long id)
    {
        return service.deleteFeedbackById(id);
    }

}
