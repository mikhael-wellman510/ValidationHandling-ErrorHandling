package com.example.ErrorHandling.Service;

import com.example.ErrorHandling.DTO.UserRequest;
import com.example.ErrorHandling.DTO.UserResponse;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);
}
