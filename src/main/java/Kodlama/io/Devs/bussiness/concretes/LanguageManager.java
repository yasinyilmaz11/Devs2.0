package Kodlama.io.Devs.bussiness.concretes;

import Kodlama.io.Devs.bussiness.abstracts.LanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    public List<Language> addLanguage(Language newLanguage) throws Exception {
        if (newLanguage.getName().isEmpty() || newLanguage.getName().isBlank()){
            throw new Exception("Hata: Dil ismi boş bırakılamaz!");
        }
        List<Language> oldData = getAll();
        boolean isDuplicate = oldData.stream()
                .anyMatch(memoryLanguage -> memoryLanguage.getName().equals(newLanguage.getName()));

        if (isDuplicate) {
            throw new Exception("Hata: Aynı isimde kayıt veritabanında mevcut!");
        } else {
            languageRepository.save(newLanguage);
        }

        return getAll();
    }

    public void delete(int languageId) {
        languageRepository.delete(languageId);
    }
}
