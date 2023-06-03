package com.geybriyel.business.service;

import com.geybriyel.business.entity.RepairJO;

import java.util.List;

public interface OrderService {
    void save(RepairJO order);
    RepairJO findById(Integer id);
    List<RepairJO> findByLastName(String lastName);
    List<RepairJO> findAll();
    void delete(Integer id);
    int deleteAll();
}
