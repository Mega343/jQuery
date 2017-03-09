package com.nixsolutions.service;

import com.nixsolutions.model.Book;

import java.util.List;

public interface BookService {

    public boolean add(Book book);

    public boolean edit(Book book);

    public boolean delete(Long id);

    public Book getBook(Long id);

    public List<Book> searchByBookName(String bookName);

    public List<Book> searchByRateGreaterThan(Integer rate);

    public List<Book> searchByReadingsGreaterThan(Integer readings);

    public List<Book> getAllBooks();

}
