package study.eng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.eng.entity.EnWordCategory;
import study.eng.service.EnWordCategoryService;

@Controller()
@RequestMapping("/admin/categories")
public class Categories {
    @Autowired
    private EnWordCategoryService categoryService;

    @Autowired
    public void setEnWordCategoryService(EnWordCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("categories", this.categoryService.findAll());
        return "/admin/categories/view";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new EnWordCategory());
        return "/admin/categories/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("category") EnWordCategory category, Model model) {
        this.categoryService.save(category);

        return "/admin/categories/add";
    }
}
