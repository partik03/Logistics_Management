package com.logistics.web.controller;

import com.logistics.web.models.Complaint;
import com.logistics.web.services.impl.ComplaintServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComplaintController {
    @Autowired
    public ComplaintServiceImpl complaintService;

    @GetMapping("/complaint")
    @ResponseBody
    public List<Complaint> getALlComplaints(){
        return complaintService.handleGetAllComplaints();
    }
    @GetMapping("/complaint/{id}")
    @ResponseBody
    public Complaint getComplaintById(@Valid @NotNull @PathVariable("id") int id){
        return complaintService.handleGetComplaintById(id);
    }
    @GetMapping("/complaintuser/{id}")
    @ResponseBody
    public List<Complaint> getALlComplaintsByUserId(@Valid @NotNull @PathVariable("id") int id){
        return complaintService.handleGetAllComplaintsByUserId(id);
    }
    @GetMapping("/complaintorder/{id}")
    @ResponseBody
    public List<Complaint> getALlComplaintsByOrderId(@Valid @NotNull @PathVariable("id") int id){
        return complaintService.handleGetAllComplaintsByOrderId(id);
    }

    @PostMapping("/complaint")
    @ResponseBody
    public int addComplaint(@Valid @NotNull @RequestBody Complaint complaint){
        return complaintService.handleAddComplaint(complaint);
    }

    @PutMapping("/complaint/{id}")
    @ResponseBody
    public int updateComplaintById(@Valid @NotNull @RequestBody Complaint complaint, @Valid @NotNull @PathVariable("id") int id){
        return complaintService.handleUpdateComplaintById(complaint,id);
    }
    @DeleteMapping("/complaint/{id}")
    @ResponseBody
    public int deleteComplaintById(@Valid @NotNull @PathVariable("id") int id){
        return complaintService.handleDeleteComplaintById(id);
    }
}
