package com.nixsolutions.dao;

import com.nixsolutions.model.Language;

import java.util.List;

public interface LanguageDAO {

    public boolean add(Language language);

    public boolean edit(Language language);

    public boolean delete(Integer id);

    public Language getLanguage(Integer id);

    public Language searchLanguageByName(String name);

    public List<Language> getAllLanguages();
}
