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
    public String addComplaint(@ModelAttribute Complaint complaint){
        complaintService.handleAddComplaint(complaint);
        return "redirect:/admin/dashboard/complaints";

    }

    @PutMapping("/complaint/{id}")
    public String updateComplaintById(@ModelAttribute Complaint complaint, @Valid @NotNull @PathVariable("id") int id){
        complaintService.handleUpdateComplaintById(complaint,id);
        return "redirect:/admin/dashboard/complaints";

    }
    @DeleteMapping("/complaint/{id}")
    public String deleteComplaintById(@Valid @NotNull @PathVariable("id") int id){
        complaintService.handleDeleteComplaintById(id);
        return "redirect:/admin/dashboard/complaints";
    }
}
