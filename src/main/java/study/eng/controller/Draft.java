package study.eng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Draft {
    @GetMapping("/draft")
    public String draft() {
        return "draft.html";
    }
}
