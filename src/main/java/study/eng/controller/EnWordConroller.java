package study.eng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.eng.entity.EnWord;
import study.eng.entity.RuWord;
import study.eng.service.EnWordCategoryService;
import study.eng.service.EnWordService;
import study.eng.service.RuWordService;

@Controller()
@RequestMapping("/admin/en-words")
public class EnWordConroller {
    @Autowired
    private EnWordCategoryService categoryService;

    @Autowired
    private EnWordService enWordService;

    @Autowired
    private RuWordService ruWordService;

    @Autowired
    public void setEnWordCategoryService(EnWordCategoryService categoryService, EnWordService enWordService, RuWordService ruWordService) {
        this.categoryService = categoryService;
        this.enWordService = enWordService;
        this.ruWordService = ruWordService;
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("words", this.enWordService.findAll());
        return "/admin/en-words/view";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("enWord", new EnWord());
        // model.addAttribute("ruWord");
        model.addAttribute("categories", this.categoryService.findAll());
        return "/admin/en-words/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam String ruWord, EnWord enWord) {
        RuWord newRuWord = new RuWord();
        newRuWord.setWord(ruWord);
        enWord.getRuWords().add(newRuWord);
        this.enWordService.save(enWord);

        newRuWord.setEnWordId(enWord.getEnWordId());
        this.ruWordService.save(newRuWord);

        return "redirect:/admin/en-words/view";
    }
}
