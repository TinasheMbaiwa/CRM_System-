package com.faramatsi.crm.feedback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {
    List<Feedback> getAllFeedback();

    void addFeedback(Feedback feedback);

    ResponseEntity< Feedback> updateFeedback(Long id, Feedback feedback);

    ResponseEntity<Feedback> deleteFeedbackById(Long id);
}
