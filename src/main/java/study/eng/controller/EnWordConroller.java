package study.eng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.eng.entity.EnWordCategory;
import study.eng.service.EnWordCategoryService;
import study.eng.service.EnWordService;

@Controller()
@RequestMapping("/admin/en-words")
public class EnWord {
    @Autowired
    private EnWordCategoryService categoryService;

    @Autowired
    private EnWordService enWordService;

    @Autowired
    public void setEnWordCategoryService(EnWordCategoryService categoryService, EnWordService enWordService) {
        this.categoryService = categoryService;
        this.enWordService = enWordService;
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("words", this.enWordService.findAll());
        return "/admin/en-words/view";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("enWord", new EnWord());
        return "/admin/en-words/add";
    }
}
