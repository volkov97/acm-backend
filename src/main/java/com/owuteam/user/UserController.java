package com.owuteam.user;

import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<?> checkUser(@RequestBody UserInfo userInfo)  {
        return userService.checkUser(userInfo);
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ResponseEntity<?> checkUser(@Param("userName") String userName, @Param("password") String password)  {
        return userService.checkUser(userName, password);
    }
}
