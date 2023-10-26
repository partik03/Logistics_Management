package com.logistics.web.services;

import com.logistics.web.models.Invoice;

import java.sql.Date;
import java.util.List;

public interface InvoiceService {

    public int handleAddInvoice(Invoice invoice);

    public Invoice handleGetInvoiceById(int id);

    public List<Invoice> handleGetAllInvoices();
    public List<Invoice> handleGetAllInvoicesByAmount(int low, int high);
    public List<Invoice> handleGetAllInvoicesByDate(Date low, Date high);
    public Invoice handleGetInvoiceByOrderId(int id);

    public int handleDeleteInvoiceById(int id);

    public int handleUpdateInvoiceById(Invoice invoice, int id);

}
