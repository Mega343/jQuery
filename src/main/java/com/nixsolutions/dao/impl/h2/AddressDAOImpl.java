package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Address;
import com.nixsolutions.dao.AddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements AddressDAO {

    private static final Logger LOG = LogManager.getLogger(AddressDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Address address) {
        LOG.traceEntry("Launched adding address to the database {}", address.toString());
        session.getCurrentSession().save(address);
        LOG.traceExit("Address {} add to the database.", address.toString());
        return true;
    }

    @Override
    public boolean edit(Address address) {
        LOG.traceEntry("Launched editing address to the database {}", address.toString());
        session.getCurrentSession().saveOrUpdate(address);
        LOG.traceExit("Address {} updated successful.", address.toString());
        return true;
    }

    @Override
    public boolean delete(Long id) {
        LOG.traceEntry("Launched deleting address from database with id = {}", id);
            Query query = session.getCurrentSession().createQuery("delete Address where addressID = :id");
            query.setParameter("id", id);
            query.executeUpdate();
        LOG.traceExit("Address with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public Address getAddress(Long id) {
        LOG.traceEntry("Launched find address by id = {}", id);
        Address address = (Address) session.getCurrentSession().get(Address.class, id);
        LOG.traceExit("Address with id = {} found in database.", id);
        return address;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
