package com.owuteam.user;

import com.owuteam.core.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> checkUser(UserInfo userInfo) {
        User user = userRepository.findByUserName(userInfo.getUserName());
        if (user == null) {
            return new ResponseEntity<>(new ResponseStatus(), HttpStatus.NOT_FOUND);
        }
        if (!user.getPassword().equals(userInfo.getPassword())) {
            return new ResponseEntity<>(new ResponseStatus(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
}
