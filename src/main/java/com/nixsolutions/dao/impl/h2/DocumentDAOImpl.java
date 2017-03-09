package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Document;
import com.nixsolutions.dao.DocumentDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DocumentDAOImpl implements DocumentDAO {

    private static final Logger LOG = LogManager.getLogger(DocumentDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Document document) {
        LOG.traceEntry("Launched adding document to the database {}", document.toString());
        session.getCurrentSession().save(document);
        LOG.traceExit("Document {} add to the database.", document.toString());
        return true;
    }

    @Override
    public boolean edit(Document document) {
        LOG.traceEntry("Launched editing document {}", document.getDocumentID());
        session.getCurrentSession().saveOrUpdate(document);
        LOG.traceExit("Document with id = {} updated successful.", document.getDocumentID());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting document from the database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete Document where documentID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Document with id = {} deleted from the database.", id);
        return true;
    }

    @Override
    public Document getDocument(Integer id) {
        LOG.traceEntry("Launched find document by id = {}", id);
        Document document = (Document) session.getCurrentSession().get(Document.class, id);
        LOG.traceExit("Document with id = {} found in the database.", id);
        return document;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
