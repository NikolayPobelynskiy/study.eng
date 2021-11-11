package study.eng.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study.eng.entity.User;

@Controller()
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }

        User user =  (User) authentication.getPrincipal();

        if (user.isUserRole()) {
            return "redirect:/personal/";

        } else if (user.isAdminRole()) {
            return "redirect:/admin/";
        }

        return "redirect:/login";
    }
}
