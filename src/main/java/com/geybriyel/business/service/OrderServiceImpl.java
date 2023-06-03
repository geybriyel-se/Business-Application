package com.geybriyel.business.service;

import com.geybriyel.business.dao.OrderDAO;
import com.geybriyel.business.entity.RepairJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Transactional
    @Override
    public void save(RepairJO order) {
        orderDAO.save(order);
    }

    @Override
    public RepairJO findById(Integer id) {
        return orderDAO.findById(id);
    }

    @Override
    public List<RepairJO> findByLastName(String lastName) {
        return orderDAO.findByLastName(lastName);
    }

    @Override
    public List<RepairJO> findAll() {
        return orderDAO.findAll();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        orderDAO.delete(id);
    }

    @Transactional
    @Override
    public int deleteAll() {
        return orderDAO.deleteAll();
    }
}
