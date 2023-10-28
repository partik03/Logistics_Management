package com.logistics.web.controller;

import com.logistics.web.models.Carrier;
import com.logistics.web.services.impl.CarrierServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarrierController {
    public CarrierServiceImpl carrierService;

    @Autowired
    public CarrierController(CarrierServiceImpl carrierService) {
        this.carrierService = carrierService;
    }

    @PostMapping("/carrier")
    public String addCarrier(@ModelAttribute Carrier carrier){
        carrierService.handleAddCarrier(carrier);
        return "redirect:/admin/dashboard/carriers";
    }

    @GetMapping("/carrier")
    @ResponseBody
    public List<Carrier> getAllCarriers(){
        return carrierService.handleGetAllCarriers();
    }

    @GetMapping("/carrier/{id}")
    @ResponseBody
    public Carrier getCarrierById(@Valid @NotNull @PathVariable("id") int id){
        return carrierService.handleGetCarrierById(id);
    }

    @DeleteMapping("/carrier/{id}")
    public String deleteCarrierById(@Valid @NotNull @PathVariable("id") int id){
        carrierService.handleDeleteCarrierById(id);
        return "redirect:/admin/dashboard/carriers";
    }

    @PutMapping("/carrier/{id}")
    public String updateCarrierById(@Valid @NotNull @PathVariable("id") int id, @ModelAttribute Carrier carrier){
        carrierService.handleUpdateCarrierById(carrier,id);
        return "redirect:/admin/dashboard/carriers";
    }
}
