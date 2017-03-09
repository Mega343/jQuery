package com.nixsolutions.service;

import com.nixsolutions.model.PublishingHouse;

import java.util.List;

public interface PublishingHouseService {

    public boolean add(PublishingHouse ph);

    public boolean edit(PublishingHouse ph);

    public boolean delete(Integer id);

    public PublishingHouse getPublishingHouse(Integer id);

    public PublishingHouse getPublishingHouseByName(String name);

    public List<PublishingHouse> getAllPublishingHouses();
}
