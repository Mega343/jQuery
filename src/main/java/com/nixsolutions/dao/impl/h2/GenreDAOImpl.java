package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Genre;
import com.nixsolutions.dao.GenreDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class GenreDAOImpl implements GenreDAO {

    private static final Logger LOG = LogManager.getLogger(GenreDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Genre genre) {
        LOG.traceEntry("Launched adding genre to the database {}", genre.getGenre());
        session.getCurrentSession().save(genre);
        LOG.traceExit("Genre {} add to the database.", genre.getGenre());
        return true;
    }

    @Override
    public boolean edit(Genre genre) {
        LOG.traceEntry("Launched editing genre {}", genre.getGenre());
        session.getCurrentSession().saveOrUpdate(genre);
        LOG.traceExit("Genre {} updated successful.", genre.getGenre());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting genre from the database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete Genre where genreID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Genre with id = {} deleted from the database.", id);
        return true;
    }

    @Override
    public Genre getGenre(Integer id) {
        LOG.traceEntry("Launched find genre by id = {}", id);
        Genre genre = (Genre) session.getCurrentSession().get(Genre.class, id);
        LOG.traceExit("Genre with id = {} found in the database.", id);
        return genre;
    }

    @Override
    public Genre searchGenreByName(String name) {
        LOG.traceEntry("Launched find genre by name = {}", name);
        Genre genre = (Genre) session.getCurrentSession().createQuery("from Genre where genre = :genre")
                .setParameter("genre", name)
                .uniqueResult();
        LOG.traceExit("Genre with name = {} found in database.", name);
        return genre;
    }

    @Override
    public List<Genre> getAllGenres() {
        LOG.traceEntry("Launched find all languages.");
        List<Genre> genreList;
        Query query = session.getCurrentSession().createQuery("from Genre");
        genreList = query.list();
        LOG.traceExit(genreList.size() + " genres found in the database.");
        return genreList;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
