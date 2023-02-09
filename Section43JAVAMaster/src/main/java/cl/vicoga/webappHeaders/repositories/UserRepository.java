package cl.vicoga.webappHeaders.repositories;

import cl.vicoga.webappHeaders.models.User;

import java.sql.SQLException;

public interface UserRepository extends Repository<User>{
    User findByName(String name)throws SQLException;
}
