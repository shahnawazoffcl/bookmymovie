package com.bookmyshowbyshah.bookmyshow.services.impl;

import com.bookmyshowbyshah.bookmyshow.Repositories.UserRepository;
import com.bookmyshowbyshah.bookmyshow.exceptions.InvalidCredentialException;
import com.bookmyshowbyshah.bookmyshow.exceptions.UserAlreadyExists;
import com.bookmyshowbyshah.bookmyshow.exceptions.UserNotFountException;
import com.bookmyshowbyshah.bookmyshow.models.User;
import com.bookmyshowbyshah.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        User user;
        if(userOptional.isEmpty()) {
            throw new UserNotFountException("User with given email doesn't exist: "+email);
        }
        user = userOptional.get();
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new InvalidCredentialException("Invalid Username or Password.");
    }

    @Override
    public User SignUp(String name, String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            throw new UserAlreadyExists("User with email already exists.");
        }
        User newUser = new User();
        newUser.setPassword(password);
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());
        return userRepository.save(newUser);
    }
}
