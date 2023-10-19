package com.logistics.web.services;

import com.logistics.web.models.Shipment;

import java.util.List;

public interface ShipmentService {

    public int handleAddShipment(Shipment shipment);

    public Shipment handleGetShipmentById(int id);

    public List<Shipment> handleGetAllShipments();

    public int handleDeleteShipmentById(int id);

    public int handleUpdateShipmentById(int id,Shipment shipment);
}
