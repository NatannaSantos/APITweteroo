package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.Users;
import com.tweteroo.api.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/sign-up")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?>  createUser(@RequestBody @Valid UserDTO req){
      var response = service.create(req);    
        return ResponseEntity.status(HttpStatusCode.valueOf(200) ).body("OK");
    }

    @GetMapping
    public List<Users> listAll(){
        return service.findAll();
    }
}
