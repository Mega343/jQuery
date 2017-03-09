package com.nixsolutions.service.impl;

import com.nixsolutions.model.Address;
import com.nixsolutions.dao.AddressDAO;
import com.nixsolutions.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;

    @Override
    public boolean add(Address address) {
        return addressDAO.add(address);
    }

    @Override
    public boolean edit(Address address) {
        return addressDAO.edit(address);
    }

    @Override
    public boolean delete(Long id) {
        return addressDAO.delete(id);
    }

    @Override
    public Address getAddress(Long id) {
        return addressDAO.getAddress(id);
    }

    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }
}
