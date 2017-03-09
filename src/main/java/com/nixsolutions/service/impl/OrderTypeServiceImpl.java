package com.nixsolutions.service.impl;

import com.nixsolutions.model.OrderType;
import com.nixsolutions.dao.OrderTypeDAO;
import com.nixsolutions.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderTypeServiceImpl implements OrderTypeService {

    @Autowired
    private OrderTypeDAO orderTypeDAO;

    @Override
    public boolean add(OrderType orderType) {
        return orderTypeDAO.add(orderType);
    }

    @Override
    public boolean edit(OrderType orderType) {
        return orderTypeDAO.edit(orderType);
    }

    @Override
    public boolean delete(Integer id) {
        return orderTypeDAO.delete(id);
    }

    @Override
    public OrderType getOrderType(Integer id) {
        return orderTypeDAO.getOrderType(id);
    }

    @Override
    public List<OrderType> getAllOrderTypes() {
        return orderTypeDAO.getAllOrderTypes();
    }

    public void setOrderTypeDAO(OrderTypeDAO orderTypeDAO) {
        this.orderTypeDAO = orderTypeDAO;
    }
}
