package Kodlama.io.Devs.webApi.controllers;

import Kodlama.io.Devs.bussiness.abstracts.LanguageService;
import Kodlama.io.Devs.entities.concretes.Language;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getAll")
    public List<Language> getAll(){
        return languageService.getAll();
    }

    @PostMapping ("/addLanguage")
    public List<Language> addLanguage(@RequestBody Language language) throws Exception {
        return languageService.addLanguage(language);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int languageId){
        languageService.delete(languageId);
    }
}
