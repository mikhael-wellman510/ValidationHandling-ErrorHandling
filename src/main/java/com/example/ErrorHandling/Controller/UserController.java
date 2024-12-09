package com.example.ErrorHandling.Controller;


import com.example.ErrorHandling.DTO.UserRequest;
import com.example.ErrorHandling.Entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @PostMapping(value = "/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest){

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
