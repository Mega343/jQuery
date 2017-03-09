package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.User;
import com.nixsolutions.dao.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


@Repository
public class UserDAOImpl implements UserDAO {

    private static final Logger LOG = LogManager.getLogger(UserDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(User user) {
        LOG.traceEntry("Launched adding user to the database {}", user.toString());
        session.getCurrentSession().save(user);
        LOG.traceExit("User add to the database = {}", user.toString());
        return true;
    }

    @Override
    public boolean edit(User user) {
        LOG.traceEntry("Launched editing user {}", user.toString());
        session.getCurrentSession().saveOrUpdate(user);
        LOG.traceExit("User with id = {} updated successful.", user.getUserID());
        return true;
    }

    @Override
    public boolean delete(Long id) {
        LOG.traceEntry("Launched deleting user from database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete User where userID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("User with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public User getUser(Long id) {
        LOG.traceEntry("Launched find user by id = {}", id);
        User user = (User) session.getCurrentSession().get(User.class, id);
        LOG.traceExit("User with id = {} found in database.", id);
        return user;
    }

    @Override
    public List<User> searchByLastName(String lastName) {
        LOG.traceEntry("Launched find users by last name {}", lastName);
        Query query = session.getCurrentSession().createQuery("from User where lastName = :lastName");
        query.setParameter("lastName", lastName);
        List<User> users = query.list();
        LOG.traceExit(users.size() + " users found in database with last name " + lastName);
        return users;
    }

    @Override
    public User searchByEmail(String email) {
        LOG.traceEntry("Launched find user by email = {}", email);
        Criteria criteria = session.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        List<User> list = criteria.list();
        if (list.isEmpty()) {
            return null;
        }
        LOG.traceExit("User with email = {} found in database.", email);
        return list.get(0);
    }


    @Override
    public List<User> getAllUsers() {
        LOG.traceEntry("Launched find all users.");
        Query query = session.getCurrentSession().createQuery("from User");
        List<User> users = query.list();
        LOG.traceExit(users.size() + " users found in the database.");
        return users;
    }

    @Override
    public List<User> getAllUnconfirmedUsers() {
        LOG.traceEntry("Launched find all unconfirmed users.");

        Query query = session.getCurrentSession().createQuery("from User where address.addressID > 0 " +
                "and document.documentID > 0 and role.userRole like '%Guest%'");
        List<User> users = query.list();

        if (users.isEmpty()) {
            throw LOG.throwing(new IllegalArgumentException("Table user is empty."));
        }
        LOG.traceExit(users.size() + " users found in the database.");
        return users;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
