package com.noxstudy.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.noxstudy.common.exceptions.NotFoundException;
import com.noxstudy.persistent.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        try
        {
            return userRepository.findByEmail(username);
        }
        catch (NotFoundException e)
        {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
