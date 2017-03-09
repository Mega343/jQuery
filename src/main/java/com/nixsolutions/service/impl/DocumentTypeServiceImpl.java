package com.nixsolutions.service.impl;

import com.nixsolutions.model.DocumentType;
import com.nixsolutions.dao.DocumentTypeDAO;
import com.nixsolutions.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    private DocumentTypeDAO documentTypeDAO;

    @Override
    public boolean add(DocumentType docType) {
        return documentTypeDAO.add(docType);
    }

    @Override
    public boolean edit(DocumentType docType) {
        return documentTypeDAO.edit(docType);
    }

    @Override
    public boolean delete(Integer id) {
        return documentTypeDAO.delete(id);
    }

    @Override
    public DocumentType getDocumentType(Integer id) {
        return documentTypeDAO.getDocumentType(id);
    }

    @Override
    public DocumentType findDocumentTypeByName(String name) {
        return documentTypeDAO.findDocumentTypeByName(name);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeDAO.getAllDocumentTypes();
    }

    public void setDocumentTypeDAO(DocumentTypeDAO documentTypeDAO) {
        this.documentTypeDAO = documentTypeDAO;
    }
}
