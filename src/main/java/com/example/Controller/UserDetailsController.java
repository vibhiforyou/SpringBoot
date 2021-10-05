package com.example.Controller;

import com.example.model.UserDetails;
import com.example.service.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserDetailsController {

    @Autowired
    IUserDetailsService userDetailsService;

    @PostMapping("/userDetails")
    public ResponseEntity createUserDetails(@RequestBody UserDetails userDetails) {
        userDetailsService.createUserDeails(userDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Details inserted successfully");
    }

    @GetMapping("/userDetails")
    public ResponseEntity getUserDetails() {
        List<UserDetails> response = userDetailsService.getUserDeails();
        if (response.size()>0) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found");
        }
    }

    @DeleteMapping("/userDetails/{id}")
    public ResponseEntity deleteUserDetails(@PathVariable int id) {
        UserDetails response = userDetailsService.deleteUserDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
