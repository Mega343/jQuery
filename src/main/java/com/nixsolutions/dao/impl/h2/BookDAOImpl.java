package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Book;
import com.nixsolutions.dao.BookDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO {

    private static final Logger LOG = LogManager.getLogger(BookDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Book book) {
        LOG.traceEntry("Launched adding book to the database {}", book.getBookName());
        session.getCurrentSession().save(book);
        LOG.traceExit("Book add to the database = {}", book.getBookName());
        return true;
    }

    @Override
    public boolean edit(Book book) {
        LOG.traceEntry("Launched editing book {}", book.getBookID());
        session.getCurrentSession().saveOrUpdate(book);
        LOG.traceExit("Book with id = {} updated successful.", book.getBookID());
        return true;
    }

    @Override
    public boolean delete(Long id) {
        LOG.traceEntry("Launched deleting book from database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete Book where bookID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Book with id = {} deleted from the database.", id);
        return true;
    }

    @Override
    public Book getBook(Long id) {
        LOG.traceEntry("Launched find book by id = {}", id);
        Book book = (Book) session.getCurrentSession().get(Book.class, id);
        LOG.traceExit("Book with id = {} found in the database.", id);
        return book;
    }

    @Override
    public List<Book> searchByBookName(String bookName) {
        LOG.traceEntry("Launched find books by book name {}", bookName);
        Query query = session.getCurrentSession().createQuery("from Book where bookName = :bookName");
        query.setParameter("bookName", bookName);
        List<Book> books = query.list();
        LOG.traceExit(books.size() + " books found in the database with book name " + bookName);
        return books;
    }

    @Override
    public List<Book> searchByRateGreaterThan(Integer rate) {
        LOG.traceEntry("Launched find books with rate greater than {}", rate);
        Query query = session.getCurrentSession().createQuery("from Book where bookRate > :bookRate");
        query.setParameter("bookRate", rate);
        List<Book> books = query.list();
        LOG.traceExit(books.size() + " books found in the database rate grater than " + rate);
        return books;
    }

    @Override
    public List<Book> searchByReadingsGreaterThan(Integer readings) {
        LOG.traceEntry("Launched find books with number of readings greater than {}", readings);
        Query query = session.getCurrentSession().createQuery("from Book where numberOfReadings > :numberOfReadings");
        query.setParameter("numberOfReadings", readings);
        List<Book> books = query.list();
        LOG.traceExit(books.size() + " books found in the database  number of readings grater than " + readings);
        return books;
    }

    @Override
    public List<Book> getAllBooks() {
        LOG.traceEntry("Launched find all books.");
        Query query = session.getCurrentSession().createQuery("from Book");
        List<Book> books = query.list();
        LOG.traceExit(books.size() + " books found in the database.");
        return books;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
