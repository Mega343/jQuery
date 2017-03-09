package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Author;
import com.nixsolutions.dao.AuthorDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class AuthorDAOImpl implements AuthorDAO {

    private static final Logger LOG = LogManager.getLogger(AuthorDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Author author) {
        LOG.traceEntry("Launched adding author to the database {}", author.getLastName());
        session.getCurrentSession().save(author);
        LOG.traceExit("Author add to the database = {}", author.getLastName());
        return true;
    }

    @Override
    public boolean edit(Author author) {
        LOG.traceEntry("Launched editing author to the database {}", author.getLastName());
        session.getCurrentSession().saveOrUpdate(author);
        LOG.traceExit("Author edited to the database = {}", author.getLastName());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting author from database with id = {}", id);

        Query query = session.getCurrentSession().createQuery("delete Author where authorID = :id");
        query.setParameter("id", id);
        query.executeUpdate();

        LOG.traceExit("Author with id = {} deleted from database.", id);
        return true;
    }

    @Override
    public Author getAuthor(Integer id) {
        LOG.traceEntry("Launched find author by id = {}", id);
        Author author = (Author) session.getCurrentSession().get(Author.class, id);
        LOG.traceExit("Author with id = {} found in database.", id);
        return author;
    }

    @Override
    public List<Author> searchByName(String lastName) {
        LOG.traceEntry("Launched find author by last name = {}", lastName);
        Query query = session.getCurrentSession().createQuery("from Author where lastName = :lastName");
        query.setParameter("lastName", lastName);
        List<Author> authors = query.list();
        LOG.traceExit(authors.size() + " authors found in database with last name " + lastName);
        return authors;
    }

    @Override
    public List<Author> searchByName(String firstName, String lastName) {
        LOG.traceEntry("Launched find author by first and last name = {} {}", lastName, firstName);
        Query query = session.getCurrentSession().
                createQuery("from Author where lastName = :lastName and firstName = :firstName");
        query.setParameter("lastName", lastName);
        query.setParameter("firstName", firstName);
        List<Author> authors = query.list();
        LOG.traceExit(authors.size() + " authors found in database with name " + firstName + " " + lastName);
        return authors;
    }

    @Override
    public List<Author> searchByName(String firstName, String lastName, String patronymic) {
        LOG.traceEntry("Launched find author by first and last name and patronymic = {} {} {}", lastName, firstName, patronymic);
        Query query = session.getCurrentSession().
                createQuery("from Author where lastName = :lastName and firstName = :firstName and patronymic = :patronymic");
        query.setParameter("lastName", lastName);
        query.setParameter("firstName", firstName);
        query.setParameter("patronymic", patronymic);
        List<Author> authors = query.list();
        LOG.traceExit(authors.size() + " authors found in database with name " + firstName + " " + lastName + " " + patronymic);
        return authors;
    }

    @Override
    public List<Author> getAllAuthors() {
        LOG.traceEntry("Launched find all authors");
        Query query = session.getCurrentSession().createQuery("from Author");
        List<Author> authors = query.list();
        LOG.traceExit(authors.size() + " authors found in database.");
        return authors;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
