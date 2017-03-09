package com.nixsolutions.service.impl;

import com.nixsolutions.model.Genre;
import com.nixsolutions.dao.GenreDAO;
import com.nixsolutions.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDAO genreDAO;

    @Override
    public boolean add(Genre genre) {
        return genreDAO.add(genre);
    }

    @Override
    public boolean edit(Genre genre) {
        return genreDAO.edit(genre);
    }

    @Override
    public boolean delete(Integer id) {
        return genreDAO.delete(id);
    }

    @Override
    public Genre getGenre(Integer id) {
        return genreDAO.getGenre(id);
    }

    @Override
    public Genre searchGenreByName(String name) {
        return genreDAO.searchGenreByName(name);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDAO.getAllGenres();
    }

    public void setGenreDAO(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }
}
