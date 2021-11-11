package study.eng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.eng.entity.RuWord;
import study.eng.service.EnWordService;
import study.eng.service.RuWordService;

@Controller()
@RequestMapping("/admin/ru-words")
public class RuWordController {
    @Autowired
    private RuWordService ruWordService;

    @Autowired
    private EnWordService enWordService;

    @Autowired
    public void setServices(RuWordService ruWordService, EnWordService enWordService) {
        this.ruWordService = ruWordService;
        this.enWordService = enWordService;
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("words", this.ruWordService.findAll());
        return "/admin/ru-words/view";
    }

    @GetMapping("/add")
    public String add(@RequestParam(name = "en_word_id") Long enWordId, Model model) throws Exception {
        RuWord ruWord = new RuWord();
        ruWord.setEnWordId(enWordId);

        model.addAttribute("ruWord", ruWord);
        model.addAttribute("enWord", this.enWordService.findById(enWordId).get());
        return "/admin/ru-words/add";
    }

    @PostMapping("/add")
    public String add(RuWord word) {
        this.ruWordService.save(word);

        return "redirect:/admin/en-words/view";
    }
}
