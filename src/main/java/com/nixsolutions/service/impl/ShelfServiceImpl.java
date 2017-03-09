package com.nixsolutions.service.impl;

import com.nixsolutions.model.Shelf;
import com.nixsolutions.dao.ShelfDAO;
import com.nixsolutions.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    private ShelfDAO shelfDAO;

    @Override
    public boolean add(Shelf shelf) {
        return shelfDAO.add(shelf);
    }

    @Override
    public boolean edit(Shelf shelf) {
        return shelfDAO.edit(shelf);
    }

    @Override
    public boolean delete(Integer id) {
        return shelfDAO.delete(id);
    }

    @Override
    public Shelf getShelf(Integer id) {
        return shelfDAO.getShelf(id);
    }

    @Override
    public Shelf searchShelfByNumber(Integer shelfNumber) {
        return shelfDAO.searchShelfByNumber(shelfNumber);
    }

    @Override
    public List<Shelf> getAllShelves() {
        return shelfDAO.getAllShelves();
    }

    public void setShelfDAO(ShelfDAO shelfDAO) {
        this.shelfDAO = shelfDAO;
    }
}
