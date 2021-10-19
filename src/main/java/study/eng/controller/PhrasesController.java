package study.eng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.eng.entity.Phrases;
import study.eng.entity.RuWord;
import study.eng.service.EnWordService;
import study.eng.service.PhrasesService;

@Controller()
@RequestMapping("/admin/phrases")
public class PhrasesController {
    @Autowired
    private PhrasesService phrasesService;

    @Autowired
    private EnWordService enWordService;

    @Autowired
    public void setEnWordCategoryService(PhrasesService phrasesService, EnWordService enWordService) {
        this.phrasesService = phrasesService;
        this.enWordService = enWordService;
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "en_word_id") Long enWordId, Model model) throws Exception {
        Phrases phrase = new Phrases();
        phrase.setEnWordId(enWordId);

        model.addAttribute("phrase", phrase);
        model.addAttribute("enWord", this.enWordService.findById(enWordId).get());
        return "/admin/phrases/add";
    }

    @PostMapping("/add")
    public String add(Phrases phrase) {
        this.phrasesService.save(phrase);

        return "redirect:/admin/en-words/view";
    }
}
