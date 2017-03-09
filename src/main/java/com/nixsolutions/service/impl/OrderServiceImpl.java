package com.nixsolutions.service.impl;

import com.nixsolutions.model.Order;
import com.nixsolutions.dao.OrderDAO;
import com.nixsolutions.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public boolean add(Order order) {
        return orderDAO.add(order);
    }

    @Override
    public boolean edit(Order order) {
        return orderDAO.edit(order);
    }

    @Override
    public boolean delete(Long id) {
        return orderDAO.delete(id);
    }

    @Override
    public Order getOrder(Long id) {
        return orderDAO.getOrder(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
