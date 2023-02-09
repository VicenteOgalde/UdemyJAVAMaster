package cl.vicoga.webappHeaders.service;

import cl.vicoga.webappHeaders.models.User;
import cl.vicoga.webappHeaders.repositories.UserRepository;
import cl.vicoga.webappHeaders.repositories.UserRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private UserRepository repository;

    public UserServiceImpl(Connection conn) {
        this.repository =new UserRepositoryImpl(conn);
    }

    @Override
    public Optional<User> login(String name, String pass)  {

        try {
            return Optional.ofNullable(repository.findByName(name))
                    .filter(f->f.getPass().equals(pass));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(),e.getCause());
        }
    }
}
