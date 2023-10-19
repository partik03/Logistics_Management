package com.logistics.web.services.impl;

import com.logistics.web.dao.ShipmentDao;
import com.logistics.web.models.Shipment;
import com.logistics.web.services.ShipmentService;

import java.util.List;

public class ShipmentServiceImpl implements ShipmentService {

    public ShipmentDao shipmentDao;

    public ShipmentServiceImpl(ShipmentDao shipmentDao){
        this.shipmentDao = shipmentDao;
    }
    public int handleAddShipment(Shipment shipment){
        return shipmentDao.addShipment(shipment);
    }

    public Shipment handleGetShipmentById(int id){
        return shipmentDao.getShipmentById(id);
    }

    public List<Shipment> handleGetAllShipments(){
        return shipmentDao.getAllShipments();
    }

    public int handleDeleteShipmentById(int id){
        return shipmentDao.deleteShipmentById(id);
    }

    public int handleUpdateShipmentById(int id,Shipment shipment){
        return shipmentDao.updateShipmentById(shipment,id);
    }
}
