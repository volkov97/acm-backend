package com.owuteam.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUserNameAndPassword(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
