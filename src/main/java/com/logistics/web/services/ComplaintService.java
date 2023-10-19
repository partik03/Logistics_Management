package com.logistics.web.services;

import com.logistics.web.models.Complaint;

import java.util.List;

public interface ComplaintService {

    public int handleAddComplaint(Complaint complaint);

    public Complaint handleGetComplaintById(int id);

    public List<Complaint> handleGetAllComplaints();

    public int handleDeleteComplaintById(int id);

    public int handleUpdateComplaintById(Complaint complaint,int id);


}
