package com.logistics.web.repository;

import com.logistics.web.models.Order;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

@EnableJdbcRepositories("com.logistics.web.repository")
//@EnableJpaRepositories
public interface OrderRespository extends Repository<Order,Long> {
    List<Order> findAllByOrderID();
    Order findByOrderID(int Id);
    List<Order> findAllByCustomerID(int Id);

    Order save(Order order);

//    List<Order>

//    Order


}
