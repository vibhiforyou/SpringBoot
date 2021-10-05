package com.example.service;

import com.example.model.UserDetails;

import java.util.List;

public interface IUserDetailsService {
    public void createUserDeails(UserDetails userDetails);

    public List<UserDetails> getUserDeails();

    public UserDetails deleteUserDetails(int id);
}
