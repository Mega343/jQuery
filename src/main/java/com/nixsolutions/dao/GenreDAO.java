package com.nixsolutions.dao;

import com.nixsolutions.model.Genre;

import java.util.List;

public interface GenreDAO {

    public boolean add(Genre genre);

    public boolean edit(Genre genre);

    public boolean delete(Integer id);

    public Genre getGenre(Integer id);

    public Genre searchGenreByName(String name);

    public List<Genre> getAllGenres();
}
