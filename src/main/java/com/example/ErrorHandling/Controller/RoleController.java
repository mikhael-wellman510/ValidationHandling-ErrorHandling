package com.example.ErrorHandling.Controller;

import com.example.ErrorHandling.DTO.RoleRequest;
import com.example.ErrorHandling.DTO.RoleResponse;
import com.example.ErrorHandling.Service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/addRole")
    ResponseEntity<?> addRole(@Valid @RequestBody RoleRequest roleRequest){

        RoleResponse roleResponse = roleService.addRole(roleRequest);

        return ResponseEntity.status(HttpStatus.OK).body(roleResponse);
    }

}
