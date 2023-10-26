package com.logistics.web.services.impl;

import com.logistics.web.dao.WarehouseDao;
import com.logistics.web.models.Warehouse;
import com.logistics.web.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    public WarehouseDao warehouseDao;

    @Autowired
    public WarehouseServiceImpl(WarehouseDao warehouseDao){
        this.warehouseDao = warehouseDao;
    }
    @Override
    public int handleAddWarehouse(Warehouse warehouse){
        return warehouseDao.addWarehouse(warehouse);
    }
    @Override
    public Warehouse handleGetWarehouseById(int id){
        return warehouseDao.getWarehouseById(id);
    }
    @Override
    public List<Warehouse> handleGetAllWarehouses(){
        return warehouseDao.getAllWarehouses();
    }
    @Override
    public int handleDeleteWarehouseById(int id){
        return warehouseDao.deleteWarehouseById(id);
    }
    @Override
    public int handleUpdateWarehouseById(int id,Warehouse warehouse){
        return warehouseDao.updateWarehouseById(warehouse,id);
    }
}
