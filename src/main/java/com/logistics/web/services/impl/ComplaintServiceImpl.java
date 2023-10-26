package com.logistics.web.services.impl;

import com.logistics.web.dao.ComplaintDao;
import com.logistics.web.models.Complaint;
import com.logistics.web.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComplaintServiceImpl implements ComplaintService {
    public ComplaintDao complaintDao;

    @Autowired
    public ComplaintServiceImpl(ComplaintDao complaintDao){
        this.complaintDao = complaintDao;
    }

    @Override
    public int handleAddComplaint(Complaint complaint){
        return complaintDao.addComplaint(complaint);
    }

    @Override
    public Complaint handleGetComplaintById(int id){
        return complaintDao.getComplaintById(id);
    }

    @Override
    public List<Complaint> handleGetAllComplaints(){
        return complaintDao.getAllComplaints();
    }

    @Override
    public int handleDeleteComplaintById(int id){
        return complaintDao.deleteComplaintById(id);
    }

    @Override
    public int handleUpdateComplaintById(Complaint complaint,int id){
        return complaintDao.updateComplaintById(complaint,id);
    }

    @Override
    public List<Complaint> handleGetAllComplaintsByOrderId(int id){
        return complaintDao.getAllComplaintsByOrderId(id);
    }

    @Override
    public List<Complaint> handleGetAllComplaintsByUserId(int id){
        return complaintDao.getAllComplaintsByUserId(id);
    }

}
