package Kodlama.io.Devs.bussiness.abstracts;

import Kodlama.io.Devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();

    List<Language> addLanguage(Language language) throws Exception;

    void delete(int languageId);
}
