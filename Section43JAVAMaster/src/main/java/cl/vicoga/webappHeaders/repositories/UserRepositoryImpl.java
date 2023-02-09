package cl.vicoga.webappHeaders.repositories;

import cl.vicoga.webappHeaders.models.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements  UserRepository{

    private Connection conn;

    public UserRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users= new ArrayList<>();
        String sql= "Select * from users";
        User user= new User();
        try(Statement s = conn.prepareStatement(sql)){

            try(ResultSet rs=s.executeQuery(sql)) {
                while(rs.next()) {
                    user.setId((long) rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setPass(rs.getString("pass"));
                    user.setEmail(rs.getString("email"));
                    users.add(user);
                }
            }

        }
        return users;
    }

    @Override
    public User findById(Long id) throws SQLException {
        String sql= "Select * from users where id=?";
        User user= new User();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1,id);
            try(ResultSet rs=ps.executeQuery()) {
                if (rs.next()) {
                    user.setId((long) rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setPass(rs.getString("pass"));
                    user.setEmail(rs.getString("email"));
                    return user;
                }
            }

        }
        return user;
    }

    @Override
    public void save(User user) throws SQLException {
        String sql;

        if (user.getId() != null && user.getId() > 0) {
            sql = "update users set name=?,pass=?,email=?  where id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, user.getName());
                ps.setString(2, user.getPass());
                ps.setString(3, user.getEmail());
                ps.setLong(4, user.getId());
                ps.executeUpdate();
            }
        } else {
            sql = "insert into users(name,pass,email) values" +
                    "(?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, user.getName());
                ps.setString(2, user.getPass());
                ps.setString(3, user.getEmail());
                ps.executeUpdate();
            }
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql= "delete from users where id=?";

        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1,id);
            ps.executeQuery();

        }

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

                }
            }

        }
        return user;
    }
}
