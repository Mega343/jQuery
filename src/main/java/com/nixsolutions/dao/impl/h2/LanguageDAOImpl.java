package com.nixsolutions.dao.impl.h2;

import com.nixsolutions.model.Language;
import com.nixsolutions.dao.LanguageDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class LanguageDAOImpl implements LanguageDAO {

    private static final Logger LOG = LogManager.getLogger(LanguageDAOImpl.class.getName());
    @Autowired
    private SessionFactory session;

    @Override
    public boolean add(Language language) {
        LOG.traceEntry("Launched adding language to the database {}", language.getLanguage());
        session.getCurrentSession().save(language);
        LOG.traceExit("Language {} add to the database.", language.getLanguage());
        return true;
    }

    @Override
    public boolean edit(Language language) {
        LOG.traceEntry("Launched editing language {}", language.getLanguage());
        session.getCurrentSession().saveOrUpdate(language);
        LOG.traceExit("Language {} updated successful.", language.getLanguage());
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        LOG.traceEntry("Launched deleting language from the database with id = {}", id);
        Query query = session.getCurrentSession().createQuery("delete Language where languageID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        LOG.traceExit("Language with id = {} deleted from the database.", id);
        return true;
    }

    @Override
    public Language getLanguage(Integer id) {
        LOG.traceEntry("Launched find language by id = {}", id);
        Language language = (Language) session.getCurrentSession().get(Language.class, id);
        LOG.traceExit("Language with id = {} found in the database.", id);
        return language;
    }

    @Override
    public Language searchLanguageByName(String name) {
        LOG.traceEntry("Launched find language by name = {}", name);
        Language language = (Language) session.getCurrentSession().createQuery("from Language where language = :name")
                .setParameter("name", name)
                .uniqueResult();
        LOG.traceExit("Language with name = {} found in database.", name);
        return language;
    }

    @Override
    public List<Language> getAllLanguages() {
        LOG.traceEntry("Launched find all languages.");
        Query query = session.getCurrentSession().createQuery("from Language");
        List<Language> languageList = query.list();
        LOG.traceExit(languageList.size() + " languages found in the database.");
        return languageList;
    }

    public void setSession(SessionFactory session) {
        this.session = session;
    }
}
