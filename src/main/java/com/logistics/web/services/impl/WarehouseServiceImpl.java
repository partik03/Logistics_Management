package com.logistics.web.services.impl;

import com.logistics.web.dao.WarehouseDao;
import com.logistics.web.models.Warehouse;
import com.logistics.web.services.WarehouseService;

import java.util.List;

public class WarehouseServiceImpl implements WarehouseService {

    public WarehouseDao warehouseDao;
    public WarehouseServiceImpl(WarehouseDao warehouseDao){
        this.warehouseDao = warehouseDao;
    }
    public int handleAddWarehouse(Warehouse warehouse){
        return warehouseDao.addWarehouse(warehouse);
    }

    public Warehouse handleGetWarehouseById(int id){
        return warehouseDao.getWarehouseById(id);
    }

    public List<Warehouse> handleGetAllWarehouses(){
        return warehouseDao.getAllWarehouses();
    }

    public int handleDeleteWarehouseById(int id){
        return warehouseDao.deleteWarehouseById(id);
    }

    public int handleUpdateWarehouseById(int id,Warehouse warehouse){
        return warehouseDao.updateWarehouseById(warehouse,id);
    }
}
