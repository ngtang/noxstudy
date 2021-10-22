package com.noxstudy.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noxstudy.core.dto.RegisteredUser;
import com.noxstudy.core.service.UserService;
import com.noxstudy.core.model.User;

@Controller
@RequestMapping(value = "user")
public class UserRestController
{
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_GUESS')")
    @GetMapping(value = "/all")
    @ResponseBody
    public List<User> findUser()
    {
        return userService.findAll();
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public ResponseEntity<RegisteredUser> register(@Valid @RequestBody RegisteredUser userDto)
    {
        userDto = userService.create(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}

