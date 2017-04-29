package com.owuteam.user;

import com.owuteam.core.ResponseStatus;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> checkUser(UserInfo userInfo);
}
