package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.PublishingHouse;
import com.nixsolutions.dao.PublishingHouseDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class PublishingHouseDAOImpl implements PublishingHouseDAO {

    private static final Logger LOG = LogManager.getLogger(PublishingHouseDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(PublishingHouse ph) {
        LOG.traceEntry("Launched adding publishing house to the database {}", ph.getPublishingHouseName());
        session.getCurrentSession().save(ph);
        LOG.traceExit("Publishing house {} add to the database.", ph.getPublishingHouseName());
        return true;
    }

    @Override
    public boolean edit(PublishingHouse ph) {
        LOG.traceEntry("Launched editing publishing house {}", ph.getPublishingHouseName());
        session.getCurrentSession().saveOrUpdate(ph);
        LOG.traceExit("Publishing house with id = {} updated successful.", ph.getPublishingHouseID());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting publishing house from database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete PublishingHouse where publishingHouseID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Publishing house with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public PublishingHouse getPublishingHouse(Integer id) {
        LOG.traceEntry("Launched find publishing house by id = {}", id);
        PublishingHouse ph = (PublishingHouse) session.getCurrentSession().get(PublishingHouse.class, id);
        LOG.traceExit("Publishing house with id = {} found in database.", id);
        return ph;
    }

    @Override
    public PublishingHouse getPublishingHouseByName(String name) {
        LOG.traceEntry("Launched find publishing house by name = {}", name);
        PublishingHouse ph = (PublishingHouse) session.getCurrentSession().createQuery("from PublishingHouse where publishingHouseName = :name")
                .setParameter("name", name)
                .uniqueResult();
        LOG.traceExit("Publishing house with name = {} found in database.", name);
        return ph;
    }

    @Override
    public List<PublishingHouse> getAllPublishingHouses() {
        LOG.traceEntry("Launched find all publishing houses.");
        Query query = session.getCurrentSession().createQuery("from PublishingHouse");
        List<PublishingHouse>  publishingHouseList = query.list();
        LOG.traceExit(publishingHouseList.size() + " publishing houses found in the database.");
        return publishingHouseList;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
