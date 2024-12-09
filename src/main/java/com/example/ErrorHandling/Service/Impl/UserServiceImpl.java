package com.example.ErrorHandling.Service.Impl;

import com.example.ErrorHandling.DTO.UserRequest;
import com.example.ErrorHandling.DTO.UserResponse;
import com.example.ErrorHandling.Repositori.UserRepository;
import com.example.ErrorHandling.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository =  userRepository;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {

        return null;
    }
}
