package com.logistics.web.controller;

import com.logistics.web.dao.CarrierDao;
import com.logistics.web.models.Carrier;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarrierController {
    private final CarrierDao carrierDao;

    public CarrierController(CarrierDao carrierDao) {
        this.carrierDao = carrierDao;
    }

    @PostMapping("/carrier")
    @ResponseBody
    public int addCarrier(@Valid @NotNull @RequestBody Carrier carrier){
        return carrierDao.addCarrier(carrier);
    }

    @GetMapping("/carrier")
    @ResponseBody
    public List<Carrier> getAllCarriers(){
        return carrierDao.getAllCarriers();
    }

    @GetMapping("/carrier/{id}")
    @ResponseBody
    public Carrier getCarrierById(@Valid @NotNull @PathVariable("id") int id){
        return carrierDao.getCarrierById(id);
    }

    @DeleteMapping("/carrier/{id}")
    @ResponseBody
    public int deleteCarrierById(@Valid @NotNull @PathVariable("id") int id){
        return carrierDao.deleteCarrierById(id);
    }

    @PutMapping("/carrier/{id}")
    @ResponseBody
    public int updateCarrierById(@Valid @NotNull @PathVariable("id") int id, @Valid @NotNull @RequestBody Carrier carrier){
        return carrierDao.updateCarrierById(carrier,id);
    }
}
