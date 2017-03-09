package com.nixsolutions.dto;

import com.nixsolutions.model.Book;
import com.nixsolutions.model.OrderType;
import com.nixsolutions.model.User;

import java.util.List;

public class OrderDTO {

    private Long librarianID;
    private Long userID;
    private Long bookID;
    private Integer orderTypeID;
    private List<Book> books;
    private List<OrderType> orderTypes;
    private List<User> users;
    private String librarianName;

    public OrderDTO() {
    }

    public OrderDTO(List<Book> books, List<OrderType> orderTypes, List<User> users, String librarianName) {
        this.books = books;
        this.orderTypes = orderTypes;
        this.users = users;
        this.librarianName = librarianName;
    }

    public Long getLibrarianID() {
        return librarianID;
    }

    public void setLibrarianID(Long librarianID) {
        this.librarianID = librarianID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public Integer getOrderTypeID() {
        return orderTypeID;
    }

    public void setOrderTypeID(Integer orderTypeID) {
        this.orderTypeID = orderTypeID;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<OrderType> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<OrderType> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }
}
