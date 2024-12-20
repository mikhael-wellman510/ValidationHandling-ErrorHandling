package com.example.ErrorHandling.Service;

import com.example.ErrorHandling.DTO.RoleRequest;
import com.example.ErrorHandling.DTO.RoleResponse;
import com.example.ErrorHandling.DTO.UserRequest;
import com.example.ErrorHandling.DTO.UserResponse;
import org.springframework.data.domain.Page;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);
    Page<UserResponse> findUserAndRole(String user , String role , Integer page ,Integer size);

}
