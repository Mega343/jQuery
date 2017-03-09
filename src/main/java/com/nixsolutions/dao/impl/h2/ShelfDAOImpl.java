package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Shelf;
import com.nixsolutions.dao.ShelfDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ShelfDAOImpl implements ShelfDAO {

    private static final Logger LOG = LogManager.getLogger(ShelfDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Shelf shelf) {
        LOG.traceEntry("Launched adding shelf to database {}", shelf.getShelfNumber());
        session.getCurrentSession().save(shelf);
        LOG.traceExit("Shelf {} add to the database.", shelf.getShelfNumber());
        return true;
    }

    @Override
    public boolean edit(Shelf shelf) {
        LOG.traceEntry("Launched editing shelf {}", shelf.getShelfNumber());
        session.getCurrentSession().saveOrUpdate(shelf);
        LOG.traceExit("Shelf id = {} updated successful.", shelf.getShelfID());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting shelf from database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete Shelf where shelfID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Shelf with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public Shelf getShelf(Integer id) {
        LOG.traceEntry("Launched find shelf by id = {}", id);
        Shelf shelf = (Shelf) session.getCurrentSession().get(Shelf.class, id);
        LOG.traceExit("Shelf with id = {} found in database.", id);
        return shelf;
    }

    @Override
    public Shelf searchShelfByNumber(Integer shelfNumber) {
        LOG.traceEntry("Launched find shelf by num = {}", shelfNumber);
        Shelf shelf  = (Shelf) session.getCurrentSession().createQuery("from Shelf where shelfNumber = :shelfNumber")
                .setParameter("shelfNumber", shelfNumber)
                .uniqueResult();
        if (shelf != null && shelf.getShelfID() == null) {
            throw LOG.throwing(new IllegalArgumentException("Shelf with num = " + shelfNumber + " absent in the database."));
        }
        LOG.traceExit("Shelf with num = {} found in database.", shelfNumber);
        return shelf;
    }


    @Override
    public List<Shelf> getAllShelves() {
        LOG.traceEntry("Launched find all shelves.");
        Query query = session.getCurrentSession().createQuery("from Shelf");
        List<Shelf> shelves = query.list();
        LOG.traceExit(shelves.size() + " shelves found in the database.");
        return shelves;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
