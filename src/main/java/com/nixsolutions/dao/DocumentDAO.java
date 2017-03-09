package com.nixsolutions.dao;

import com.nixsolutions.model.Document;

public interface DocumentDAO {

    public boolean add(Document document);

    public boolean edit(Document document);

    public boolean delete(Integer id);

    public Document getDocument(Integer id);

}
