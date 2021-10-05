package com.example.service;

import com.example.dao.IUserDetailsDao;
import com.example.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService {

    @Autowired
    IUserDetailsDao userDetailsDao;

    @Override
    public void createUserDeails(UserDetails userDetails) {
        userDetailsDao.createUserDetails(userDetails);
    }

    @Override
    public List<UserDetails> getUserDeails() {
        return userDetailsDao.getUserDetails();
    }

    @Override
    public UserDetails deleteUserDetails(int id) {
        return userDetailsDao.deleteUserDetails(id);
    }
}
