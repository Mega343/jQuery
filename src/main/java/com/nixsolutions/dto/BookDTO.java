package com.nixsolutions.dto;

import com.nixsolutions.model.Book;


public class BookDTO {

    private Long bookID;
    private String bookName;
    private Integer yearOfIssue;
    private String bookDescription;
    private Integer bookQuantity;
    private Integer bookInWarehouse;
    private Integer bookRate;
    private Integer numberOfReadings;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String publishingHouseName;
    private String genre;
    private String language;
    private Integer shelfNumber;

    public static BookDTO getBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO(book.getBookID(), book.getBookName(), book.getYearOfIssue(), book.getBookDescription() ,
                book.getBookQuantity(), book.getBookInWarehouse(), book.getBookRate(), book.getNumberOfReadings(), book.getAuthor().getFirstName(),
                book.getAuthor().getLastName(), book.getAuthor().getPatronymic(), book.getPh().getPublishingHouseName(),
                book.getGenre().getGenre(), book.getLanguage().getLanguage(), book.getShelf().getShelfNumber());
        return bookDTO;
    }

    public static Book getBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookID(bookDTO.getBookID());
        book.setBookName(bookDTO.getBookName());
        book.setBookQuantity(bookDTO.getBookQuantity());
        book.setBookInWarehouse(bookDTO.getBookInWarehouse());
        book.setBookRate(bookDTO.getBookRate());
        book.setNumberOfReadings(bookDTO.getNumberOfReadings());
        book.setYearOfIssue(bookDTO.getYearOfIssue());
        book.setBookDescription(bookDTO.getBookDescription());
        return book;
    }


    public BookDTO() {
    }

    public BookDTO(Long bookID, String bookName, Integer yearOfIssue, String bookDescription, Integer bookQuantity,
                   Integer bookInWarehouse, Integer bookRate, Integer numberOfReadings, String firstName,
                   String lastName, String patronymic, String publishingHouseName, String genre, String language,
                   Integer shelfNumber) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.yearOfIssue = yearOfIssue;
        this.bookDescription = bookDescription;
        this.bookQuantity = bookQuantity;
        this.bookInWarehouse = bookInWarehouse;
        this.bookRate = bookRate;
        this.numberOfReadings = numberOfReadings;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.publishingHouseName = publishingHouseName;
        this.genre = genre;
        this.language = language;
        this.shelfNumber = shelfNumber;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Integer yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public Integer getBookInWarehouse() {
        return bookInWarehouse;
    }

    public void setBookInWarehouse(Integer bookInWarehouse) {
        this.bookInWarehouse = bookInWarehouse;
    }

    public Integer getBookRate() {
        return bookRate;
    }

    public void setBookRate(Integer bookRate) {
        this.bookRate = bookRate;
    }

    public Integer getNumberOfReadings() {
        return numberOfReadings;
    }

    public void setNumberOfReadings(Integer numberOfReadings) {
        this.numberOfReadings = numberOfReadings;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public String getPublishingHouseName() {
        return publishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        this.publishingHouseName = publishingHouseName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public Integer getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(Integer shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

}
