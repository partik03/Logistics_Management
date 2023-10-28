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
    @Autowired
    public WarehouseServiceImpl warehouseService;

    
    public WarehouseController(WarehouseServiceImpl warehouseService){
        this.warehouseService = warehouseService;
    }

    @GetMapping("/warehouse")
    // @ResponseBody
    public String getAllWarehouses(){

        return "warehouse";
        // return warehouseService.handleGetAllWarehouses();
    }

    @GetMapping("/warehouse/{id}")
    @ResponseBody
    public Warehouse getWarehouseById(@Valid @NotNull @PathVariable("id") int id){
        return warehouseService.handleGetWarehouseById(id);
    }

    @PostMapping("/warehouse")
    public String addWarehouse(@ModelAttribute Warehouse warehouse){
        warehouseService.handleAddWarehouse(warehouse);
        return "redirect:/admin/dashboard/warehouses";

    }

    @PutMapping("/warehouse/{id}")
    public String updateWarehouseById(@ModelAttribute Warehouse warehouse, @Valid @NotNull @PathVariable("id") int id){
        warehouseService.handleUpdateWarehouseById(id,warehouse);
                return "redirect:/admin/dashboard/warehouses";

    }

    @DeleteMapping("/warehouse/{id}")
    public String deleteWarehouseById(@Valid @NotNull @PathVariable("id") int id){
        warehouseService.handleDeleteWarehouseById(id);
                return "redirect:/admin/dashboard/warehouses";

    }
}
