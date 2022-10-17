package com.yuni.likeit.controller;

import com.yuni.likeit.dto.UserDTO;
import com.yuni.likeit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUp(@RequestBody UserDTO receivedUser) {
        boolean result = userService.signUp(receivedUser);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserDTO receivedUser) {
        boolean result = userService.login(receivedUser);
        if(result)
            return ResponseEntity.status(HttpStatus.OK).body(result);
        else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
    }

    @GetMapping("/getUser")
    public UserDTO getUser() {
        UserDTO user = userService.findUserByEmail();
        System.out.println(user);
        return user;
    }
}
