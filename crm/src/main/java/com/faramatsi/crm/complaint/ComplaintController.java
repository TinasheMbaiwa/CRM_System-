package com.faramatsi.crm.complaint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crm/complaints/v1")
public class ComplaintController {
    ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }
    @GetMapping
    public List<Complaint> getAllComplaints(){
      return   service.getAllComplaints();
    }

    @PostMapping("add/")
    public void addComplaint(@RequestBody Complaint complaint){
        service.addComplaint(complaint);
    }
}
