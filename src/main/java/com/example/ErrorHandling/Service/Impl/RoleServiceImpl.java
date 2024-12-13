package com.example.ErrorHandling.Service.Impl;

import com.example.ErrorHandling.DTO.RoleRequest;
import com.example.ErrorHandling.DTO.RoleResponse;
import com.example.ErrorHandling.DTO.UserResponse;
import com.example.ErrorHandling.Entity.Role;
import com.example.ErrorHandling.Repositori.RoleRepository;
import com.example.ErrorHandling.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleResponse addRole(RoleRequest roleRequest) {

        Role addrole = roleRepository.save(Role.builder()
                        .roleName(roleRequest.getRoleName())
                        .description(roleRequest.getDescription())
                .build());

        return RoleResponse.builder()
                .id(addrole.getId())
                .roleName(addrole.getRoleName())
                .description(addrole.getDescription())
                .build();
    }

    @Override
    public Role findRoleById(String roleId) {

        Role find = roleRepository.findById(roleId).orElseThrow(NoSuchElementException::new);

        return find;
    }

}
