package com.logistics.web.services;

import com.logistics.web.models.Warehouse;

import java.util.List;

public interface WarehouseService {
    public int handleAddWarehouse(Warehouse warehouse);

    public Warehouse handleGetWarehouseById(int id);

    public List<Warehouse> handleGetAllWarehouses();

    public int handleDeleteWarehouseById(int id);

    public int handleUpdateWarehouseById(int id,Warehouse warehouse);
}
