package com.nixsolutions.service;

import com.nixsolutions.model.DocumentType;

import java.util.List;

public interface DocumentTypeService {

    public boolean add(DocumentType docType);

    public boolean edit(DocumentType docType);

    public boolean delete(Integer id);

    public DocumentType getDocumentType(Integer id);

    public DocumentType findDocumentTypeByName(String name);

    public List<DocumentType> getAllDocumentTypes();
}
