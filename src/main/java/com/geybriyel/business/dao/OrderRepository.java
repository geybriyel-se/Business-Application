package com.geybriyel.business.dao;

import com.geybriyel.business.entity.RepairJO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<RepairJO, Integer> {
    public List<RepairJO> findByLastName(String lastName);
    public void deleteAll();
}
