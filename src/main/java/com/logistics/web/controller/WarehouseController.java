package com.logistics.web.controller;

import com.logistics.web.models.Warehouse;
import com.logistics.web.services.impl.WarehouseServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WarehouseController {
    public WarehouseServiceImpl warehouseService;

    @Autowired
    public WarehouseController(WarehouseServiceImpl warehouseService){
        this.warehouseService = warehouseService;
    }

    @GetMapping("/warehouse")
    @ResponseBody
    public List<Warehouse> getAllWarehouses(){
        return warehouseService.handleGetAllWarehouses();
    }

    @GetMapping("/warehouse/{id}")
    @ResponseBody
    public Warehouse getWarehouseById(@Valid @NotNull @PathVariable("id") int id){
        return warehouseService.handleGetWarehouseById(id);
    }

    @PostMapping("/warehouse")
    @ResponseBody
    public int addWarehouse(@Valid @NotNull @RequestBody Warehouse warehouse){
        return warehouseService.handleAddWarehouse(warehouse);
    }

    @PutMapping("/warehouse/{id}")
    @ResponseBody
    public int updateWarehouseById(@Valid @NotNull @RequestBody Warehouse warehouse, @Valid @NotNull @PathVariable("id") int id){
        return warehouseService.handleUpdateWarehouseById(id,warehouse);
    }

    @DeleteMapping("/warehouse/{id}")
    @ResponseBody
    public int deleteWarehouseById(@Valid @NotNull @PathVariable("id") int id){
        return warehouseService.handleDeleteWarehouseById(id);
    }
}
