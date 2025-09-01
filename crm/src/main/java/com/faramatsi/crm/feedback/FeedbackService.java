package com.faramatsi.crm.feedback;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedbackService {
    List<Feedback> getAllFeedback();

    void addFeedback(Feedback feedback);
}
