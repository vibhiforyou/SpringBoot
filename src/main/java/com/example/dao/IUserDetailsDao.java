package com.example.dao;

import com.example.model.UserDetails;

import java.util.List;

public interface IUserDetailsDao {
    public void createUserDetails(UserDetails userDetails);

    public List<UserDetails> getUserDetails();

    public UserDetails deleteUserDetails(int id);
}
