package com.logistics.web.services.impl;

import com.logistics.web.dao.CarrierDao;
import com.logistics.web.models.Carrier;
import com.logistics.web.services.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierServiceImpl implements CarrierService {

    public CarrierDao carrierDao;


    @Autowired
    public CarrierServiceImpl(CarrierDao carrierDao){
        this.carrierDao = carrierDao;
    }

    @Override
    public int handleAddCarrier(Carrier carrier){
        return carrierDao.addCarrier(carrier);
    }

    @Override
    public Carrier handleGetCarrierById(int id){
        return carrierDao.getCarrierById(id);
    }

    @Override
    public List<Carrier> handleGetAllCarriers(){
        return carrierDao.getAllCarriers();
    }

    @Override
    public int handleDeleteCarrierById(int id){
        return carrierDao.deleteCarrierById(id);
    }

    @Override
    public int handleUpdateCarrierById(Carrier carrier, int id){
        return carrierDao.updateCarrierById(carrier,id);
    }


}
