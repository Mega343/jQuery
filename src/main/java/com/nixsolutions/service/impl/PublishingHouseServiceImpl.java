package com.nixsolutions.service.impl;

import com.nixsolutions.model.PublishingHouse;
import com.nixsolutions.dao.PublishingHouseDAO;
import com.nixsolutions.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublishingHouseServiceImpl implements PublishingHouseService {

    @Autowired
    private PublishingHouseDAO publishingHouseDAO;

    @Override
    public boolean add(PublishingHouse ph) {
        return publishingHouseDAO.add(ph);
    }

    @Override
    public boolean edit(PublishingHouse ph) {
        return publishingHouseDAO.edit(ph);
    }

    @Override
    public boolean delete(Integer id) {
        return publishingHouseDAO.delete(id);
    }

    @Override
    public PublishingHouse getPublishingHouse(Integer id) {
        return publishingHouseDAO.getPublishingHouse(id);
    }

    @Override
    public PublishingHouse getPublishingHouseByName(String name) {
        return publishingHouseDAO.getPublishingHouseByName(name);
    }

    @Override
    public List<PublishingHouse> getAllPublishingHouses() {
        return publishingHouseDAO.getAllPublishingHouses();
    }

    public void setPublishingHouseDAO(PublishingHouseDAO publishingHouseDAO) {
        this.publishingHouseDAO = publishingHouseDAO;
    }
}
