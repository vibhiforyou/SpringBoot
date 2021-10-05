package com.example.dao;

import com.example.model.UserDetails;
import com.example.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class UserDetailsDaoImpl implements IUserDetailsDao {


    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void createUserDetails(UserDetails userDetails) {
        jdbcTemplate.update("insert into userdetails(id,username,password) values(?,?,?)", userDetails.getId(), userDetails.getUsername(), userDetails.getPassword());
    }

    @Override
    public List<UserDetails> getUserDetails() {
        return jdbcTemplate.query("select * from userdetails", (rs, rowNum) ->
                new UserDetails(rs.getInt("id"), rs.getString("username"), rs.getString("password"))
        );
    }

    @Override
    public UserDetails deleteUserDetails(int id) {
        UserDetails existingUserDetails = getUserDetailsById(id);
        if (existingUserDetails != null) {
            jdbcTemplate.update("delete userdetails where id=?", id);
        }
        return existingUserDetails;
    }

    private UserDetails getUserDetailsById(int id) {
        return jdbcTemplate.queryForObject("select * from userdetails where id=?", new Object[]{id}, (rs, rowNum) -> new UserDetails(rs.getInt("id"), rs.getString("username"), rs.getString("password")));

    }


}
