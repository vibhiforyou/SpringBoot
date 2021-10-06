package com.example.Controller;

import com.example.model.UserDetails;
import com.example.service.IUserDetailsService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserDetailsController {

    private static final Logger logger = LogManager.getLogger(UserDetailsController.class);

    @Autowired
    IUserDetailsService userDetailsService;

    @PostMapping("/userDetails")
    public ResponseEntity createUserDetails(@RequestBody UserDetails userDetails) {
        userDetailsService.createUserDeails(userDetails);
        logger.debug("User Details inserted successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body("User Details inserted successfully");
    }

    @GetMapping("/userDetails")
    public ResponseEntity getUserDetails() {
        List<UserDetails> response = userDetailsService.getUserDeails();
        if (response.size() > 0) {
            logger.debug("No of records found ");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            logger.debug("No records found");
            logger.error("No records found");
            logger.info("No records found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records found");
        }
    }

    @DeleteMapping("/userDetails/{id}")
    public ResponseEntity deleteUserDetails(@PathVariable int id) {
        UserDetails response = userDetailsService.deleteUserDetails(id);
        logger.debug("Record Deleted Successfully");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
