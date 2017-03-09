package com.nixsolutions.service.impl;

import com.nixsolutions.model.Book;
import com.nixsolutions.dao.BookDAO;
import com.nixsolutions.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public boolean add(Book book) {
        return bookDAO.add(book);
    }

    @Override
    public boolean edit(Book book) {
        return bookDAO.edit(book);
    }

    @Override
    public boolean delete(Long id) {
        return bookDAO.delete(id);
    }

    @Override
    public Book getBook(Long id) {
        return bookDAO.getBook(id);
    }

    @Override
    public List<Book> searchByBookName(String bookName) {
        return bookDAO.searchByBookName(bookName);
    }

    @Override
    public List<Book> searchByRateGreaterThan(Integer rate) {
        return bookDAO.searchByRateGreaterThan(rate);
    }

    @Override
    public List<Book> searchByReadingsGreaterThan(Integer readings) {
        return bookDAO.searchByReadingsGreaterThan(readings);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
}
