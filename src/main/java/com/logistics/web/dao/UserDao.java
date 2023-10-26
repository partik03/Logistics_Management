package com.logistics.web.dao;

import com.logistics.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;


@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addUser(User user){
        String sql = "INSERT INTO User(firstName,lastName,contact,age,address,dateOfBirth,authority,username) VALUES(?,?,?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getContact());
            ps.setInt(4,user.getAge());
            ps.setString(5,user.getAddress());
            ps.setDate(6,user.getDateOfBirth());
            ps.setString(7, String.valueOf(user.getAuthority())); // role is an enum
            ps.setString(8,user.getUsername());
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public User getUserById(int id){
        String sql = "SELECT * FROM User WHERE userId = ?";
        User user= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    public List<User> getAllUsers(){
        String sql = "SELECT * FROM User";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public int deleteUserById(int id){
        String sql = "DELETE FROM User WHERE userId = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateUserById(User user, int id){
        String sql = "UPDATE User SET firstName=?, lastName=?, contact=?, authority=? WHERE userId = ?";
        return jdbcTemplate.update(sql,user.getFirstName(),user.getLastName(),user.getContact(),user.getAuthority(),id);
    }
}