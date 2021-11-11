package study.eng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.eng.entity.Dictionary;
import study.eng.entity.EnWord;
import study.eng.entity.RuWord;
import study.eng.entity.User;
import study.eng.service.DictionaryService;
import study.eng.service.EnWordService;

import java.util.*;
import java.util.stream.Collectors;

@Controller()
@RequestMapping("/personal")
public class PersonalPageController {
    @GetMapping("/")
    public String mainPage() {
        return "personal/main";
    }

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private EnWordService enWordService;

    public void setServices(DictionaryService dictionary) {
        this.enWordService = enWordService;
        this.dictionaryService = dictionary;
    }

    @GetMapping("/dictionary")
    public String dictionary(Model model) throws Exception {
        User user = study.eng.security.Authentication.initUser();
        Dictionary userDictionary = user.getDictionary();

        model.addAttribute("enWords", userDictionary.getEnWords());

        return "personal/dictionary";
    }

    @GetMapping("/dictionary-add")
    public String dictionaryAdd(Model model) throws Exception {
        User user = study.eng.security.Authentication.initUser();
        Dictionary userDictionary = user.getDictionary();

        List itemsArray = new ArrayList();

        for (EnWord itm : this.enWordService.findAll()) {
            Map item = new HashMap();
            item.put(itm.getEnWordId(), itm.getEnWordId());
            item.put("word", itm);
            item.put("wordIsAdded", userDictionary.findEnWord(itm));
            itemsArray.add(item);
        }

        model.addAttribute("dictionaryService", this.dictionaryService);
        model.addAttribute("words", itemsArray);

        return "personal/dictionary-add";
    }

    @GetMapping("/add")
    public String dictionaryAdd(@RequestParam(name = "en_word_id") Long enWordId) throws Exception {
        User user = study.eng.security.Authentication.initUser();
        Dictionary userDictionary = user.getDictionary();
        Optional<EnWord> word = enWordService.findById(enWordId);

        userDictionary.addEnWord(word.get());
        this.dictionaryService.save(userDictionary);

        return "redirect:/personal/dictionary-add";
    }

    @GetMapping("/remove")
    public String dictionaryDelete(@RequestParam(name = "en_word_id") Long enWordId) throws Exception {
        User user = study.eng.security.Authentication.initUser();
        Dictionary userDictionary = user.getDictionary();
        EnWord word = enWordService.findById(enWordId).orElseThrow(() -> new Exception("Undefined en_word_id"));

        Set wordSet = userDictionary.getEnWords().stream()
                .filter(wd -> wd.getEnWordId() != word.getEnWordId()).collect(Collectors.toSet());

        userDictionary.setEnWords(wordSet);
        this.dictionaryService.save(userDictionary);

        return "redirect:/personal/dictionary-add";
    }
}