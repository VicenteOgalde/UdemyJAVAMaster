package cl.vicoga.webappHeaders.service;

import cl.vicoga.webappHeaders.models.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserService {

    Optional<User> login(String name, String pass) ;
}
