package com.nixsolutions.dao;

import com.nixsolutions.model.User;

import java.util.List;

public interface UserDAO {

    public boolean add(User user);

    public boolean edit(User user);

    public boolean delete(Long id);

    public User getUser(Long id);

    public List<User> searchByLastName(String lastName);

    public User searchByEmail(String email);

    public List<User> getAllUsers();

    public List<User> getAllUnconfirmedUsers();

}
