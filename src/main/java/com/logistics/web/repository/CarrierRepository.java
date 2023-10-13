package com.logistics.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logistics.web.models.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier,Long > {

}
