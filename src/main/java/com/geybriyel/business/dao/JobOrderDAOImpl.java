package com.geybriyel.business.dao;

import com.geybriyel.business.entity.RepairJO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JobOrderDAOImpl implements OrderDAO {
    private EntityManager entityManager;

    @Autowired
    public JobOrderDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(RepairJO order) {
        this.entityManager.persist(order);
    }

    @Override
    public RepairJO findById(Integer id) {
        return this.entityManager.find(RepairJO.class, id);
    }
}
