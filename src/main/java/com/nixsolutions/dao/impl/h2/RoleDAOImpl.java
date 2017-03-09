package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Role;
import com.nixsolutions.dao.RoleDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private static final Logger LOG = LogManager.getLogger(RoleDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Role role) {
        LOG.traceEntry("Launched adding role to the database {}", role.getUserRole());
        session.getCurrentSession().save(role);
        LOG.traceExit("Role {} add to the database.", role.getUserRole());
        return true;
    }

    @Override
    public boolean edit(Role role) {
        LOG.traceEntry("Launched editing role {}", role.getUserRole());
        session.getCurrentSession().saveOrUpdate(role);
        LOG.traceExit("Role {} updated successful.", role.getUserRole());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting role from database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete Role where roleID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Role with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public Role getRole(Integer id) {
        LOG.traceEntry("Launched find role by id = {}", id);
        Role role = (Role) session.getCurrentSession().get(Role.class, id);
        LOG.traceExit("Role with id = {} found in database.", id);
        return role;
    }

    @Override
    public Role getRoleByName(String userRole) {
        LOG.traceEntry("Launched find role by name = {}", userRole);
        Role role = (Role) session.getCurrentSession().createQuery("from Role where userRole = :name")
                .setParameter("name", userRole)
                .uniqueResult();
        LOG.traceExit("Role with name = {} found in database.", userRole);
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        LOG.traceEntry("Launched find all roles.");
        Query query = session.getCurrentSession().createQuery("from Role");
        List<Role> roles = query.list();
        LOG.traceExit(roles.size() + " roles found in the database.");
        return roles;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
