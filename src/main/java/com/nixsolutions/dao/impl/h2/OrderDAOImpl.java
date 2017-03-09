package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Order;
import com.nixsolutions.dao.OrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final Logger LOG = LogManager.getLogger(OrderDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Order order) {
        LOG.traceEntry("Launched adding order to the database {}", order.toString());
        session.getCurrentSession().save(order);
        LOG.traceExit("Order add to the database = {}", order.toString());
        return true;
    }

    @Override
    public boolean edit(Order order) {
        LOG.traceEntry("Launched editing order to the database {}", order.toString());
        session.getCurrentSession().saveOrUpdate(order);
        LOG.traceExit("Order updated successful = {}", order.toString());
        return true;
    }

    @Override
    public boolean delete(Long id) {
        LOG.traceEntry("Launched deleting order from database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete Order where orderID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Order with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public Order getOrder(Long id) {
        LOG.traceEntry("Launched find order by id = {}", id);
        Order order = (Order) session.getCurrentSession().get(Order.class, id);
        LOG.traceExit("Order with id = {} found in database.", id);
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        LOG.traceEntry("Launched find all order.");
        Query query = session.getCurrentSession().createQuery("from Order");
        List<Order> orders = query.list();
        LOG.traceExit(orders.size() + " found in the database.");
        return orders;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
