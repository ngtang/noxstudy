package com.noxstudy.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import com.noxstudy.authentication.models.Credential;
import com.noxstudy.persistent.entity.UserEntity;
import com.noxstudy.rest.factory.jwt.TokenHelper;

@Controller
public class AuthenticationRestService
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenHelper tokenHelper;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<com.noxstudy.authentication.models.Authentication> authenticate(@RequestBody Credential credential)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserEntity user = (UserEntity) authentication.getPrincipal();

        final String token = tokenHelper.generateToken(user.getUsername());

        com.noxstudy.authentication.models.Authentication response = new com.vn.green.authentication.models.Authentication();
        response.setToken(token);
        response.setExpiredIn(tokenHelper.getExpiresIn());
        return ResponseEntity.ok(response);
    }
}