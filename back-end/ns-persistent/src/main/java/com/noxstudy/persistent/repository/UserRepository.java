package com.noxstudy.persistent.repository;
import java.util.List;

import com.noxstudy.common.exceptions.NotFoundException;
import com.noxstudy.persistent.entity.Authority;
import com.noxstudy.persistent.entity.UserEntity;

public interface UserRepository extends GenericDao<UserEntity>
{
    List<Authority> getAllAuthorities();

    UserEntity findByEmail(String email) throws NotFoundException;
}
