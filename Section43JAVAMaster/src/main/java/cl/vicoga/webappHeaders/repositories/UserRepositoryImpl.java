package cl.vicoga.webappHeaders.repositories;

import cl.vicoga.webappHeaders.models.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements  UserRepository{

    private Connection conn;

    public UserRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<User> findAll() throws SQLException {
        return null;
    }

    @Override
    public User findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public void save(User user) throws SQLException {

    }

    @Override
    public void deleteById(Long id) throws SQLException {

    }

    @Override
    public User findByName(String name) throws SQLException {
        String sql= "Select * from users where name=?";
        User user= new User();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,name);
            try(ResultSet rs=ps.executeQuery()) {
                if (rs.next()) {
                    user.setId((long) rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setPass(rs.getString("pass"));
                    user.setEmail(rs.getString("email"));
                    return user;
                }
            }

        }catch (SQLException e){
            return user;
        }


        return user;
    }
}
