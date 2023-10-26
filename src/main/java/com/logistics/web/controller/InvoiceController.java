package com.logistics.web.controller;

import com.logistics.web.models.Invoice;
import com.logistics.web.services.impl.InvoiceServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class InvoiceController {
    @Autowired
    public InvoiceServiceImpl invoiceService;

    @GetMapping("/invoice")
    @ResponseBody
    public List<Invoice> getAllInvoices(){
        return invoiceService.handleGetAllInvoices();
    }

    @GetMapping("/invoice/{id}")
    @ResponseBody
    public Invoice getInvoiceById(@Valid @NotNull @PathVariable("id") int id){
        return invoiceService.handleGetInvoiceById(id);
    }
    @GetMapping("/invoiceorder/{id}")
    @ResponseBody
    public Invoice getInvoiceByOrderId(@Valid @NotNull @PathVariable("id") int id){
        return invoiceService.handleGetInvoiceByOrderId(id);
    }
    @GetMapping("/invoiceamount")
    @ResponseBody
    public List<Invoice> getInvoiceByAmount(@RequestParam(name = "low") int low, @RequestParam(name = "high") int high){
        return invoiceService.handleGetAllInvoicesByAmount(low,high);
    }
    @GetMapping("/invoicedate")
    @ResponseBody
    public List<Invoice> getInvoiceByDate(@RequestParam(name = "low") Date low, @RequestParam(name = "high") Date high){
        return invoiceService.handleGetAllInvoicesByDate(low,high);
    }

    @PostMapping("/invoice")
    @ResponseBody
    public int addInvoice(@Valid @NotNull @RequestBody Invoice invoice){
        return invoiceService.handleAddInvoice(invoice);
    }

    @PutMapping("/invoice/{id}")
    @ResponseBody
    public int updateInvoiceById(@Valid @NotNull @RequestBody Invoice invoice, @Valid @NotNull @PathVariable("id") int id){
        return invoiceService.handleUpdateInvoiceById(invoice,id);
    }

    @DeleteMapping("/invoice/{id}")
    @ResponseBody
    public int deleteInvoiceById(@Valid @NotNull @PathVariable("id") int id){
        return invoiceService.handleDeleteInvoiceById(id);
    }
}
