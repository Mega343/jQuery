package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.OrderType;
import com.nixsolutions.dao.OrderTypeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderTypeDAOImpl implements OrderTypeDAO {

    private static final Logger LOG = LogManager.getLogger(OrderTypeDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(OrderType orderType) {
        LOG.traceEntry("Launched adding order type to the database {}", orderType.getOrderType());
        session.getCurrentSession().save(orderType);
        LOG.traceExit("Order type {} add to the database.", orderType.getOrderType());
        return true;
    }

    @Override
    public boolean edit(OrderType orderType) {
        LOG.traceEntry("Launched editing order type {}", orderType.getOrderType());
        session.getCurrentSession().saveOrUpdate(orderType);
        LOG.traceExit("Order type {} updated successful.", orderType.getOrderType());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting order type from database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete OrderType where orderTypeID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Order type with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public OrderType getOrderType(Integer id) {
        LOG.traceEntry("Launched find order type by id = {}", id);
        OrderType orderType = (OrderType) session.getCurrentSession().get(OrderType.class, id);
        LOG.traceExit("Order type with id = {} found in database.", id);
        return orderType;
    }

    @Override
    public List<OrderType> getAllOrderTypes() {
        LOG.traceEntry("Launched find all order types.");
        Query query = session.getCurrentSession().createQuery("from OrderType");
        List<OrderType> orderTypeList = query.list();
        LOG.traceExit(orderTypeList.size() + " order types found in the database.");
        return orderTypeList;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
