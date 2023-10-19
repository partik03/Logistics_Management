package com.logistics.web.services.impl;

import com.logistics.web.dao.CarrierDao;
import com.logistics.web.models.Carrier;
import com.logistics.web.services.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CarrierServiceImpl implements CarrierService {

    public CarrierDao carrierDao;


    @Autowired
    public CarrierServiceImpl(CarrierDao carrierDao){
        this.carrierDao = carrierDao;
    }

    public int handleAddCarrier(Carrier carrier){
        return carrierDao.addCarrier(carrier);
    }

    public Carrier handleGetCarrierById(int id){
        return carrierDao.getCarrierById(id);
    }
    public List<Carrier> handleGetAllCarriers(){
        return carrierDao.getAllCarriers();
    }

    public int handleDeleteCarrierById(int id){
        return carrierDao.deleteCarrierById(id);
    }

    public int handleUpdateCarrierById(Carrier carrier, int id){
        return carrierDao.updateCarrierById(carrier,id);
    }


}
