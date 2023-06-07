package com.geybriyel.business.service;

import com.geybriyel.business.dao.OrderRepository;
import com.geybriyel.business.entity.RepairJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderDAO) {
        this.orderRepository = orderDAO;
    }

    @Transactional
    @Override
    public void save(RepairJO order) {
        orderRepository.save(order);
    }

    @Override
    public RepairJO findById(Integer id) {
        Optional<RepairJO> result = orderRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find order id - " + id);
        }
    }

    @Override
    public List<RepairJO> findByLastName(String lastName) {
        return orderRepository.findByLastName(lastName);
    }

    @Override
    public List<RepairJO> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
