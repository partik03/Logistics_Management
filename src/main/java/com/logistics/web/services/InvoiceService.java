package com.logistics.web.services;

import com.logistics.web.models.Invoice;

import java.util.List;

public interface InvoiceService {

    public int handleAddInvoice(Invoice invoice);

    public Invoice handleGetInvoiceById(int id);

    public List<Invoice> handleGetAllInvoices();

    public int handleDeleteInvoiceById(int id);

    public int handleUpdateInvoiceById(Invoice invoice, int id);

}
