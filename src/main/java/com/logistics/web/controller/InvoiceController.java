package com.logistics.web.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.web.models.Invoice;
import com.logistics.web.models.Razorpay;
import com.logistics.web.services.impl.AuthenticationServiceImpl;
import com.logistics.web.services.impl.InvoiceServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class InvoiceController {
    @Autowired
    public InvoiceServiceImpl invoiceService;

     @Autowired
    public AuthenticationServiceImpl authenticationService;

    @GetMapping("/invoice")
    @ResponseBody
    public List<Invoice> getAllInvoices() {
        return invoiceService.handleGetAllInvoices();
    }

    @GetMapping("/invoice/{id}")
    @ResponseBody
    public Invoice getInvoiceById(@Valid @NotNull @PathVariable("id") int id) {
        return invoiceService.handleGetInvoiceById(id);
    }

    @GetMapping("/invoiceorder/{id}")
    @ResponseBody
    public Invoice getInvoiceByOrderId(@Valid @NotNull @PathVariable("id") int id) {
        return invoiceService.handleGetInvoiceByOrderId(id);
    }

    @GetMapping("/invoiceamount")
    @ResponseBody
    public List<Invoice> getInvoiceByAmount(@RequestParam(name = "low") int low,
            @RequestParam(name = "high") int high) {
        return invoiceService.handleGetAllInvoicesByAmount(low, high);
    }

    @GetMapping("/invoicedate")
    @ResponseBody
    public List<Invoice> getInvoiceByDate(@RequestParam(name = "low") Date low,
            @RequestParam(name = "high") Date high) {
        return invoiceService.handleGetAllInvoicesByDate(low, high);
    }

    @PostMapping("/invoice")
    public String addInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.handleAddInvoice(invoice);
        return "redirect:/admin/dashboard/invoices";

    }

    @PutMapping("/invoice/{id}")
    public String updateInvoiceById(@ModelAttribute Invoice invoice, @Valid @NotNull @PathVariable("id") int id) {
        invoiceService.handleUpdateInvoiceById(invoice, id);
        return "redirect:/admin/dashboard/invoices";

    }

    @DeleteMapping("/invoice/{id}")
    public String deleteInvoiceById(@Valid @NotNull @PathVariable("id") int id) {
        invoiceService.handleDeleteInvoiceById(id);
        return "redirect:/admin/dashboard/invoices";
    }

    @PostMapping("/user/invoice/success")
    public String handleSuccess(@RequestBody String requestBody ){
        try {
            String[] arr = requestBody.split("&");
            // ObjectMapper objectMapper = new ObjectMapper();
            // JsonNode jsonNode = objectMapper.readTree(requestBody);

            // // Extract the order ID from the JSON
            // String orderId = jsonNode.get("order_id").asText();

            // Print the order ID
            System.out.println("Received Razorpay callback for Order ID: " + requestBody);
            for(int i = 0; i < arr.length; i++)System.out.println(arr[i]);
            String orderId = arr[1].split("=")[1];
            invoiceService.handlePaymentSuccess(orderId);

            // Respond with a success message
            return "redirect:/user/invoices";
        } catch (Exception e) {
            // Handle JSON parsing or other exceptions here
            // You may want to log the error for debugging purposes.
            System.out.println(e);
            return "redirect:/user/invoices";
        }
    }
    
    
}
