package cl.vicoga.webappHeaders.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceCookieImpl implements LoginService{
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {

        return Arrays.stream(req.getCookies()!=null?req.getCookies():new Cookie[0])
                .filter(c->c.getName().equals("user"))
                .findFirst().map(Cookie::getValue);
    }
}
