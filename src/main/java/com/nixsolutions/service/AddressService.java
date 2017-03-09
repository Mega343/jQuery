package com.nixsolutions.service;

import com.nixsolutions.model.Address;

public interface AddressService {

    public boolean add(Address address);

    public boolean edit(Address address);

    public boolean delete(Long id);

    public Address getAddress(Long id);
}
