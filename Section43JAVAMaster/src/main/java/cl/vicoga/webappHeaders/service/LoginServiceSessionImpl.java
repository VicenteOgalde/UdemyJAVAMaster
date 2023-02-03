package cl.vicoga.webappHeaders.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public class LoginServiceSessionImpl implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {

        return req.getSession().getAttribute("user") != null
                ? Optional.of((String) req.getSession().getAttribute("user"))
                : Optional.empty();


    }
}
