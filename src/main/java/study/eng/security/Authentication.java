package study.eng.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import study.eng.entity.User;

public class Authentication {
    /**
     * @return
     * @throws Exception
     */
    public static User initUser() throws Exception {
        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new Exception("Undefined User");
        }

        return (User) authentication.getPrincipal();
    }
}