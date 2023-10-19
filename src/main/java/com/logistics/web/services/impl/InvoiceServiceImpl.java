package com.logistics.web.services.impl;

import com.logistics.web.dao.InvoiceDao;
import com.logistics.web.models.Invoice;
import com.logistics.web.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    public InvoiceDao invoiceDao;

    @Autowired
    public InvoiceServiceImpl(InvoiceDao invoiceDao){
        this.invoiceDao = invoiceDao;
    }

    public int handleAddInvoice(Invoice invoice){
        return invoiceDao.addInvoice(invoice);
    }

    public Invoice handleGetInvoiceById(int id){
        return invoiceDao.getInvoiceById(id);
    }

    public List<Invoice> handleGetAllInvoices(){
        return invoiceDao.getAllInvoices();
    }

    public int handleDeleteInvoiceById(int id){
        return invoiceDao.deleteInvoiceById(id);
    }

    public int handleUpdateInvoiceById(Invoice invoice, int id){
        return invoiceDao.updateInvoiceById(invoice,id);
    }


}
