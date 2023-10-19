package com.logistics.web.services.impl;

import com.logistics.web.dao.ComplaintDao;
import com.logistics.web.models.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComplaintServiceImpl {
    public ComplaintDao complaintDao;

    @Autowired
    public ComplaintServiceImpl(ComplaintDao complaintDao){
        this.complaintDao = complaintDao;
    }

    public int handleAddComplaint(Complaint complaint){
        return complaintDao.addComplaint(complaint);
    }

    public Complaint handleGetComplaintById(int id){
        return complaintDao.getComplaintById(id);
    }

    public List<Complaint> handleGetAllComplaints(){
        return complaintDao.getAllComplaints();
    }

    public int handleDeleteComplaintById(int id){
        return complaintDao.deleteComplaintById(id);
    }

    public int handleUpdateComplaintById(Complaint complaint,int id){
        return complaintDao.updateComplaintById(complaint,id);
    }


}
