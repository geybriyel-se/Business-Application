package com.geybriyel.business.dao;

import com.geybriyel.business.entity.RepairJO;

public interface OrderDAO {
    void save(RepairJO order);

    RepairJO findById(Integer id);
}
