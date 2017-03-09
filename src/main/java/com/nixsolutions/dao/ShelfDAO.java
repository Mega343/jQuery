package com.nixsolutions.dao;

import com.nixsolutions.model.Shelf;

import java.util.List;

public interface ShelfDAO {

    public boolean add(Shelf shelf);

    public boolean edit(Shelf shelf);

    public boolean delete(Integer id);

    public Shelf getShelf(Integer id);

    public Shelf searchShelfByNumber(Integer shelfNumber);

    public List<Shelf> getAllShelves();
}
