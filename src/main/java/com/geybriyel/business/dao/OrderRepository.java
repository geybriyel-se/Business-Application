package com.geybriyel.business.dao;

import com.geybriyel.business.entity.RepairJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<RepairJO, Integer> {

}
