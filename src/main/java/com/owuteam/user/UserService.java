package com.owuteam.user;

import org.springframework.data.repository.query.Param;

public interface UserService {
    User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
