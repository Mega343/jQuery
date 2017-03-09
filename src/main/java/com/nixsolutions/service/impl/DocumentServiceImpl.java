package com.nixsolutions.service.impl;

import com.nixsolutions.model.Document;
import com.nixsolutions.dao.DocumentDAO;
import com.nixsolutions.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public boolean add(Document document) {
        return documentDAO.add(document);
    }

    @Override
    public boolean edit(Document document) {
        return documentDAO.edit(document);
    }

    @Override
    public boolean delete(Integer id) {
        return documentDAO.delete(id);
    }

    @Override
    public Document getDocument(Integer id) {
        return documentDAO.getDocument(id);
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }
}
