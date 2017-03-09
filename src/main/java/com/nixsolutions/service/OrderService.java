package com.nixsolutions.service;

import com.nixsolutions.model.Order;

import java.util.List;

public interface OrderService {

    public boolean add(Order order);

    public boolean edit(Order order);

    public boolean delete(Long id);

    public Order getOrder(Long id);

    public List<Order> getAllOrders();
}
