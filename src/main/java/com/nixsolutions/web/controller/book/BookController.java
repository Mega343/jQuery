package com.nixsolutions.web.controller.book;

import com.nixsolutions.model.*;
import com.nixsolutions.dto.BookDTO;
import com.nixsolutions.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    private static final Logger LOG = LogManager.getLogger(BookController.class.getName());
    private List<Author> authors;

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private PublishingHouseService publishingHouseService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private ShelfService shelfService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String viewBooksList(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping(value = "/book_delete", method = RequestMethod.GET)
    public String bookDelete(@RequestParam("book_id") String bookID, Model model) {
       Book book = bookService.getBook(Long.parseLong(bookID));
        if (book.getBookQuantity() > 1) {
            if (book.getBookInWarehouse().equals(book.getBookQuantity())) {
                book.setBookQuantity(book.getBookQuantity() - 1);
                book.setBookInWarehouse(book.getBookInWarehouse() - 1);
                bookService.edit(book);
                return "redirect:/books";
            } else {
                book.setBookQuantity(book.getBookQuantity() - 1);
                bookService.edit(book);
                return "redirect:/books";
            }
        } else {
            try {
                bookService.delete(book.getBookID());
                return "redirect:/books";
            } catch (Exception e) {
                book.setBookQuantity(0);
                book.setBookInWarehouse(0);
                bookService.edit(book);
                model.addAttribute("error", "Cannot delete book which used in orders. Book quantity set 0.");
                return "books";
            }
        }
    }

    @RequestMapping(value = "/book_description", method = RequestMethod.POST)
    public String viewBookDescription(HttpServletRequest req, Model model) {
        String bookDescription = req.getParameter("book_description");
        model.addAttribute("book_description", bookDescription);
        return "bookDescription";
    }

    @RequestMapping(value = "/update_book", method = RequestMethod.GET)
    public ModelAndView viewBookUpdateForm(@RequestParam("book_id") String bookID) {
        try{
            Book book = bookService.getBook(Long.parseLong(bookID));
            BookDTO bookDTO = BookDTO.getBookDTO(book);
            return new ModelAndView("updateBook", "book", bookDTO);
        } catch (Exception e) {
            LOG.catching(e);
            throw LOG.throwing(new RuntimeException(e));
        }
    }

    @RequestMapping(value = "/update_book", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") BookDTO bookDTO) {
        String authorFullName[] = bookDTO.getFirstName().split(" ");
        Book book = BookDTO.getBook(bookDTO);
        validateFields(bookDTO, book, authorFullName);
        bookService.edit(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/add_book", method = RequestMethod.GET)
    public String bookAddView() {
        return "addBook";
    }

    @RequestMapping(value = "/add_book", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") BookDTO bookDTO) {
        String authorFullName[] = bookDTO.getFirstName().split(" ");
        Book book = BookDTO.getBook(bookDTO);
        validateFields(bookDTO, book, authorFullName);
        book.setBookRate(0);
        book.setNumberOfReadings(0);
        bookService.add(book);
        return "redirect:/books";
    }

    private void validateFields(BookDTO bookDTO, Book book, String[] authorFullName) {
       Author author = searchAuthorByName(authorFullName);
       if(author.getAuthorID() == null) {
            author.setFirstName(authorFullName[0]);
            author.setLastName(authorFullName[1]);
            if (authorFullName.length == 3) {
                author.setPatronymic(authorFullName[2]);
            }
            authorService.add(author);
        }

        PublishingHouse ph = publishingHouseService.getPublishingHouseByName(bookDTO.getPublishingHouseName());
        if(ph == null || ph.getPublishingHouseID() == null) {
            ph = new PublishingHouse(bookDTO.getPublishingHouseName());
            publishingHouseService.add(ph);
        }

        Genre genre = genreService.searchGenreByName(bookDTO.getGenre());
        if(genre == null || genre.getGenreID() == null) {
            genre = new Genre(bookDTO.getGenre());
            genreService.add(genre);
        }

        Language language = languageService.searchLanguageByName(bookDTO.getLanguage());
        if(language == null || language.getLanguageID() == null) {
            language = new Language(bookDTO.getLanguage());
            languageService.add(language);
        }

        Shelf shelf = shelfService.searchShelfByNumber(bookDTO.getShelfNumber());
        if(shelf == null || shelf.getShelfID() == null) {
            shelf = new Shelf(bookDTO.getShelfNumber());
            shelfService.add(shelf);
        }
        book.setShelf(shelf);
        book.setAuthor(author);
        book.setLanguage(language);
        book.setGenre(genre);
        book.setPh(ph);
    }

    private Author searchAuthorByName(String[] authorFullName) {
        Author author = new Author();
        if (authorFullName.length == 2) {
            authors = authorService.searchByName(authorFullName[0], authorFullName[1]);
            if (authors.size() > 0) {
                author = authors.get(0);
            }
        } else if (authorFullName.length == 3) {
            authors = authorService.searchByName(authorFullName[0], authorFullName[1], authorFullName[2]);
            if(authors.size() > 0) {
                author = authors.get(0);
            }
        }
        return author;
    }
}
