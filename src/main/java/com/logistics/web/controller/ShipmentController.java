package com.logistics.web.controller;

import com.logistics.web.models.Shipment;
import com.logistics.web.services.impl.ShipmentServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class ShipmentController {
    public ShipmentServiceImpl shipmentService;

    @Autowired
    public ShipmentController(ShipmentServiceImpl shipmentService){
        this.shipmentService = shipmentService;
    }

    @PostMapping("/shipment")
    @ResponseBody
    public int addShipment(@Valid @NotNull @RequestBody Shipment shipment){
        return shipmentService.handleAddShipment(shipment);
    }

    @GetMapping("/shipment")
    @ResponseBody
    public List<Shipment> getAllShipments(){
        return shipmentService.handleGetAllShipments();
    }

    @GetMapping("/shipment/{id}")
    @ResponseBody
    public Shipment getShipmentById(@Valid @NotNull @PathVariable("id") int id){
        return shipmentService.handleGetShipmentById(id);
    }

    @DeleteMapping("/shipment/{id}")
    @ResponseBody
    public int deleteShipmentById(@Valid @NotNull @PathVariable("id") int id){
        return shipmentService.handleDeleteShipmentById(id);
    }

    @PutMapping("/shipment/{id}")
    @ResponseBody
    public int updateShipmentById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody Shipment shipment){
        return shipmentService.handleUpdateShipmentById(id,shipment);
    }

    @GetMapping("/shipmentorder/{id}")
    @ResponseBody
    public List<Shipment> getAllShipmentsByOrderId(@Valid @NotNull @PathVariable("id") int id){
        return shipmentService.handleGetAllShipmentsByOrderId(id);
    }

    @GetMapping("/shipmentcarrier/{id}")
    @ResponseBody
    public List<Shipment> getAllShipmentsByCarrierId(@Valid @NotNull @PathVariable("id") int id){
        return shipmentService.handleGetAllShipmentsByCarrierId(id);
    }

    @GetMapping("/shipmentwarehouse/{id}")
    @ResponseBody
    public List<Shipment> getAllShipmentsByWarehouseId(@Valid @NotNull @PathVariable("id") int id){
        return shipmentService.handleGetAllShipmentsByWarehouseId(id);
    }

    @GetMapping("/shipmentstatus/{status}")
    @ResponseBody
    public List<Shipment> getAllShipmentsByStatus(@Valid @NotNull @PathVariable("status") String status){
        return shipmentService.handleGetAllShipmentsByStatus(status);
    }

    @GetMapping("/shipmentdate")
    @ResponseBody
    public List<Shipment> getAllShipmentsByShipmentDate(Date low, Date high){
        return shipmentService.handleGetAllShipmentsByShipmentDate(low,high);
    }

    @GetMapping("/shipmentdeliverydate")
    @ResponseBody
    public List<Shipment> getAllShipmentByEstimatedDeliveryDate(Date low, Date high){
        return shipmentService.handleGetAllShipmentsByEstimatedDeliveryDate(low,high);
    }
}
