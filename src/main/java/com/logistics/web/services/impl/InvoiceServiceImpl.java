package com.logistics.web.services.impl;

import com.logistics.web.dao.InvoiceDao;
import com.logistics.web.models.Invoice;
import com.logistics.web.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    public InvoiceDao invoiceDao;

    @Autowired
    public InvoiceServiceImpl(InvoiceDao invoiceDao){
        this.invoiceDao = invoiceDao;
    }

    @Override
    public int handleAddInvoice(Invoice invoice){
        return invoiceDao.addInvoice(invoice);
    }

    @Override
    public Invoice handleGetInvoiceById(int id){
        return invoiceDao.getInvoiceById(id);
    }

    @Override
    public List<Invoice> handleGetAllInvoices(){
        return invoiceDao.getAllInvoices();
    }

    @Override
    public List<Invoice> handleGetAllInvoicesByAmount(int low, int high) {
        return invoiceDao.getAllInvoicesByAmount(low,high);
    }

    @Override
    public List<Invoice> handleGetAllInvoicesByDate(Date low, Date high) {
        return invoiceDao.getAllInvoicesByDate(low,high);
    }

    @Override
    public Invoice handleGetInvoiceByOrderId(int id) {
        return invoiceDao.getInvoiceByOrderId(id);
    }

    @Override
    public int handleDeleteInvoiceById(int id){
        return invoiceDao.deleteInvoiceById(id);
    }

    @Override
    public int handleUpdateInvoiceById(Invoice invoice, int id){
        return invoiceDao.updateInvoiceById(invoice,id);
    }

    @Override
    public int handlePaymentSuccess(String orderId){
        return invoiceDao.paymentSuccess(orderId);
    }
}
