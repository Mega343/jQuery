package com.nixsolutions.dao;


import com.nixsolutions.model.DocumentType;

import java.util.List;

public interface DocumentTypeDAO {

    public boolean add(DocumentType docType);

    public boolean edit(DocumentType docType);

    public boolean delete(Integer id);

    public DocumentType getDocumentType(Integer id);

    public DocumentType findDocumentTypeByName(String name);

    public List<DocumentType> getAllDocumentTypes();
}
