package com.noxstudy.core.service;
import java.util.List;

import com.noxstudy.core.dto.RegisteredUser;
import com.noxstudy.core.model.User;

public interface UserService
{
    List<User> findAll();

    RegisteredUser create(RegisteredUser registeredUser);
}
