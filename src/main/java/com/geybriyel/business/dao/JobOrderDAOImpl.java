package com.geybriyel.business.dao;

import com.geybriyel.business.entity.RepairJO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<RepairJO> findByLastName(String lastName) {
        TypedQuery<RepairJO> query = entityManager.createQuery("FROM RepairJO WHERE lastName=:param", RepairJO.class);
        query.setParameter("param", lastName);
        return query.getResultList();
    }

    @Override
    public List<RepairJO> findAll() {
        TypedQuery<RepairJO> query = entityManager.createQuery("FROM RepairJO ORDER BY lastName", RepairJO.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(RepairJO repairJO) {
        this.entityManager.merge(repairJO);
    }

}
