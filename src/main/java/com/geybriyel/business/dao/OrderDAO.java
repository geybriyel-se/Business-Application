package com.geybriyel.business.dao;

import com.geybriyel.business.entity.RepairJO;

import java.util.List;

public interface OrderDAO {
    void save(RepairJO order);

    RepairJO findById(Integer id);

    List<RepairJO> findByLastName(String lastName);

    List<RepairJO> findAll();

    void update(RepairJO repairJO);

    void delete(Integer id);

    int deleteAll();
}
