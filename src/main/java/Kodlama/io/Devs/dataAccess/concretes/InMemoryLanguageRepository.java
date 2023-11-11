package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    ArrayList<Language> languages;
    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"C#"));
        languages.add(new Language(2,"Java"));
        languages.add(new Language(3,"Python"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }
    @Override
    public void save(Language language){
        languages.add(language);
    }

    @Override
    public void delete(int languageId){
        languages.removeIf(language -> language.getId() == languageId);
    }
}
