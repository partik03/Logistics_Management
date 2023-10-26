package com.logistics.web.services;

import com.logistics.web.models.Shipment;

import java.sql.Date;
import java.util.List;

public interface ShipmentService {

    public int handleAddShipment(Shipment shipment);

    public Shipment handleGetShipmentById(int id);

    public List<Shipment> handleGetAllShipments();

    public int handleDeleteShipmentById(int id);

    public int handleUpdateShipmentById(int id,Shipment shipment);

    public List<Shipment> handleGetAllShipmentsByOrderId(int id);
    public List<Shipment> handleGetAllShipmentsByCarrierId(int id);
    public List<Shipment> handleGetAllShipmentsByWarehouseId(int id);
    public List<Shipment> handleGetAllShipmentsByStatus(String status);
    public List<Shipment> handleGetAllShipmentsByShipmentDate(Date low, Date high);
    public List<Shipment> handleGetAllShipmentsByEstimatedDeliveryDate(Date low, Date high);

}
