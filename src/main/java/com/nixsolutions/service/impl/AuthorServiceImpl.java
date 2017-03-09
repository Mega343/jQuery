package com.nixsolutions.service.impl;

import com.nixsolutions.model.Author;
import com.nixsolutions.dao.AuthorDAO;
import com.nixsolutions.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public boolean add(Author author) {
        return authorDAO.add(author);
    }

    @Override
    public boolean edit(Author author) {
        return authorDAO.edit(author);
    }

    @Override
    public boolean delete(Integer id) {
        return authorDAO.delete(id);
    }

    @Override
    public Author getAuthor(Integer id) {
        return authorDAO.getAuthor(id);
    }

    @Override
    public List<Author> searchByName(String lastName) {
        return authorDAO.searchByName(lastName);
    }

    @Override
    public List<Author> searchByName(String firstName, String lastName) {
        return authorDAO.searchByName(firstName, lastName);
    }

    @Override
    public List<Author> searchByName(String firstName, String lastName, String patronymic) {
        return authorDAO.searchByName(firstName, lastName, patronymic);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }
}
