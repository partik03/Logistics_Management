package com.logistics.web.repository;

import com.logistics.web.models.Carrier;

@Repository
public class CarrierRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarrierRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
