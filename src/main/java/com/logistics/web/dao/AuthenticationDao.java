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
public class AuthenticationDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthenticationDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addCustomer(User user){
        String sql = "INSERT INTO User(username,password,firstName,lastName,contact,age,address,dateOfBirth,authority) VALUES(?,?,?,?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.setString(5,user.getContact());
            ps.setInt(6,user.getAge());
            ps.setString(7,user.getAddress());
            ps.setDate(8,user.getDateOfBirth());
            ps.setString(9, "C");
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }
    public int addAdmin(User user){
        String sql = "INSERT INTO User(username,password,firstName,lastName,contact,age,address,dateOfBirth,authority) VALUES(?,?,?,?,?,?,?,?,?)";
        KeyHolder keyholder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4,user.getLastName());
            ps.setString(5,user.getContact());
            ps.setInt(6,user.getAge());
            ps.setString(7,user.getAddress());
            ps.setDate(8,user.getDateOfBirth());
            ps.setString(9, String.valueOf((user.getAuthority())));
            return ps;
        }, keyholder);

        return Objects.requireNonNull(keyholder.getKey()).intValue();
    }

    public User getUserById(int id){
        String sql = "SELECT * FROM User WHERE userId = ?";
        User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);
        return user;
    }

    public User getUserByUsername(String username){
        String sql = "SELECT * FROM User WHERE username = \""+username+"\"";
        User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public List<User> getAllCustomers(){
        String sql = "SELECT * FROM User WHERE authority = \"C\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> getAllEmployees(){
        String sql = "SELECT * FROM User WHERE NOT authority = \"C\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
    public List<User> getAllAdminsByAuthority(String authority){
        String sql = "SELECT * FROM User WHERE authority = \"" + authority+"\"";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }
    public int deleteUserById(int id){
        String sql = "DELETE FROM User WHERE userId=?";
        return jdbcTemplate.update(sql,id);
    }

    public int updateUserById(User user, int id){
        String sql = "UPDATE User SET username=?, password=?, firstName=?, lastName=?, contact=?, age=?, address=?, dateOfBirth=?, authority=? WHERE userId=?";
        return jdbcTemplate.update(sql, user.getUsername(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getContact(),user.getAge(),user.getAddress(),user.getDateOfBirth(),String.valueOf(user.getAuthority()),id);
    }
}
