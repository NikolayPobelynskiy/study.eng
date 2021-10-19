package study.eng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import study.eng.entity.RuWord;
import study.eng.entity.User;
import study.eng.repository.RuWordRepository;
import study.eng.service.RuWordService;
import study.eng.service.UserService;

@Controller
public class Draft {
    /**
     *
     * Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     * if (!(authentication instanceof AnonymousAuthenticationToken)) {
     *     String currentUserName = authentication.getName();
     *     return currentUserName;
     * }
     *
     * @AuthenticationPrincipal User user
     *
     */


    @Autowired
    private RuWordService ruWordService;

//    @Autowired
//    private RuWordRepository ruWordRepository;

    @Autowired
    public void setRuWordService(RuWordService ruWordService) {
        this.ruWordService = ruWordService;
    }

    @GetMapping("/draft")
    public String draft() {

        //RuWordService ruWordService1 = new RuWordService(this.ruWordRepository);

        RuWord wd = new RuWord();
        wd.setId(1L);
        wd.setEnWordId(1L);
        wd.setWord("sfvdsfvdsfvb");
        ruWordService.save(wd);




        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println(currentUserName);
        }

        System.out.println("No Loged");
        return "draft.html";
    }
}
