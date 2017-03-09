package com.nixsolutions.service.impl;

import com.nixsolutions.model.Language;
import com.nixsolutions.dao.LanguageDAO;
import com.nixsolutions.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageDAO languageDAO;

    @Override
    public boolean add(Language language) {
        return languageDAO.add(language);
    }

    @Override
    public boolean edit(Language language) {
        return languageDAO.edit(language);
    }

    @Override
    public boolean delete(Integer id) {
        return languageDAO.delete(id);
    }

    @Override
    public Language getLanguage(Integer id) {
        return languageDAO.getLanguage(id);
    }

    @Override
    public Language searchLanguageByName(String name) {
        return languageDAO.searchLanguageByName(name);
    }

    @Override
    public List<Language> getAllLanguages() {
        return languageDAO.getAllLanguages();
    }

    public void setLanguageDAO(LanguageDAO languageDAO) {
        this.languageDAO = languageDAO;
    }
}
