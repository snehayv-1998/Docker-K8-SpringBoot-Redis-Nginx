package com.example.springbootWithDocker.controller;
import com.example.springbootWithDocker.dto.LoginRequestDto;
import com.example.springbootWithDocker.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @CrossOrigin(origins = {"http://localhost:63342","http://localhost/"})
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        return userDetailsService.login(loginRequestDto);
    }

}
