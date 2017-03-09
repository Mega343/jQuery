package com.nixsolutions.service.impl;

import com.nixsolutions.model.Role;
import com.nixsolutions.dao.RoleDAO;
import com.nixsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public boolean add(Role role) {
        return roleDAO.add(role);
    }

    @Override
    public boolean edit(Role role) {
        return roleDAO.edit(role);
    }

    @Override
    public boolean delete(Integer id) {
        return roleDAO.delete(id);
    }

    @Override
    public Role getRole(Integer id) {
        return roleDAO.getRole(id);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
}
