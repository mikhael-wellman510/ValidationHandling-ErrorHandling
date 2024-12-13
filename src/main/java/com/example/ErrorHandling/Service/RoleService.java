package com.example.ErrorHandling.Service;


import com.example.ErrorHandling.DTO.RoleRequest;
import com.example.ErrorHandling.DTO.RoleResponse;
import com.example.ErrorHandling.DTO.UserResponse;
import com.example.ErrorHandling.Entity.Role;
import org.springframework.data.domain.Page;

public interface RoleService {
    RoleResponse addRole(RoleRequest roleRequest);

    Role findRoleById(String roleId);
}

