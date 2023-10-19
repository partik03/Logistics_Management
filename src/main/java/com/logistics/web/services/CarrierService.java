package com.logistics.web.services;

import com.logistics.web.models.Carrier;

import java.util.List;


public interface CarrierService {

    public int handleAddCarrier(Carrier carrier);

    public Carrier handleGetCarrierById(int id);
    public List<Carrier> handleGetAllCarriers();

    public int handleDeleteCarrierById(int id);

    public int handleUpdateCarrierById(Carrier carrier, int id);

    

}
