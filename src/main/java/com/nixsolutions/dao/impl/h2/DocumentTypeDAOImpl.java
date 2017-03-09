package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.DocumentType;
import com.nixsolutions.dao.DocumentTypeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentTypeDAOImpl implements DocumentTypeDAO {

    private static final Logger LOG = LogManager.getLogger(DocumentTypeDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(DocumentType docType) {
        LOG.traceEntry("Launched adding document type to the database {}", docType.getDocumentType());
        session.getCurrentSession().save(docType);
        LOG.traceExit("Document type {} add to the database.", docType.getDocumentType());
        return true;
    }

    @Override
    public boolean edit(DocumentType docType) {
        LOG.traceEntry("Launched editing document type {}", docType.getDocumentType());
        session.getCurrentSession().saveOrUpdate(docType);
        LOG.traceExit("Document type {} updated successful.", docType.getDocumentType());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting document type from the database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete DocumentType where documentTypeID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Document type with id = {} deleted from the database.", id);
        return true;
    }

    @Override
    public DocumentType getDocumentType(Integer id) {
        LOG.traceEntry("Launched find document type by id = {}", id);
        DocumentType docType = (DocumentType) session.getCurrentSession().get(DocumentType.class, id);
        LOG.traceExit("Document type with id = {} found in the database.", id);
        return docType;
    }

    @Override
    public DocumentType findDocumentTypeByName(String name) {
        LOG.traceEntry("Launched find document type by name = {}", name);
        Query query = session.getCurrentSession().createQuery("from DocumentType where documentType = :name");
        query.setParameter("name", name);
        List<DocumentType> list = query.list();
        LOG.traceExit("Document type with name = {} found in database.", name);
        return list.get(0);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        LOG.traceEntry("Launched find all document types.");
        Query query = session.getCurrentSession().createQuery("from DocumentType");
        List<DocumentType> documentTypeList = query.list();
        LOG.traceExit(documentTypeList.size() + " document types found in the database.");
        return documentTypeList;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
