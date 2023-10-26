package com.logistics.web.services.impl;

import com.logistics.web.dao.ShipmentDao;
import com.logistics.web.models.Shipment;
import com.logistics.web.services.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    public ShipmentDao shipmentDao;

    @Autowired
    public ShipmentServiceImpl(ShipmentDao shipmentDao){
        this.shipmentDao = shipmentDao;
    }

    @Override
    public int handleAddShipment(Shipment shipment){
        return shipmentDao.addShipment(shipment);
    }

    @Override
    public Shipment handleGetShipmentById(int id){
        return shipmentDao.getShipmentById(id);
    }

    @Override
    public List<Shipment> handleGetAllShipments(){
        return shipmentDao.getAllShipments();
    }

    @Override
    public int handleDeleteShipmentById(int id){
        return shipmentDao.deleteShipmentById(id);
    }

    @Override
    public int handleUpdateShipmentById(int id,Shipment shipment){
        return shipmentDao.updateShipmentById(shipment,id);
    }

    @Override
    public List<Shipment> handleGetAllShipmentsByOrderId(int id) {
        return shipmentDao.getAllShipmentsByOrderId(id);
    }

    @Override
    public List<Shipment> handleGetAllShipmentsByCarrierId(int id) {
        return shipmentDao.getAllShipmentsByCarrierId(id);
    }

    @Override
    public List<Shipment> handleGetAllShipmentsByWarehouseId(int id) {
        return shipmentDao.getAllShipmentsByWarehouseId(id);
    }

    @Override
    public List<Shipment> handleGetAllShipmentsByStatus(String status) {
        return shipmentDao.getAllShipmentsByStatus(status);
    }

    @Override
    public List<Shipment> handleGetAllShipmentsByShipmentDate(Date low, Date high) {
        return shipmentDao.getAllShipmentsByShipmentDate(low,high);
    }

    @Override
    public List<Shipment> handleGetAllShipmentsByEstimatedDeliveryDate(Date low, Date high) {
        return shipmentDao.getAllShipmentsByEstimatedDeliveryDate(low,high);
    }
}
