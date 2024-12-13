package com.example.ErrorHandling.Controller;


import com.example.ErrorHandling.DTO.Paging.Data;
import com.example.ErrorHandling.DTO.Paging.Pageable;
import com.example.ErrorHandling.DTO.Paging.PaggingAndFilterResponse;
import com.example.ErrorHandling.DTO.Paging.Sort;
import com.example.ErrorHandling.DTO.UserRequest;
import com.example.ErrorHandling.DTO.UserResponse;
import com.example.ErrorHandling.Entity.User;
import com.example.ErrorHandling.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest) {

        UserResponse userResponse = userService.addUser(userRequest);

        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<?> findUserAndRole(@RequestParam(name = "user", required = false) String user, @RequestParam(name = "role", required = false) String role, @RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "size", defaultValue = "5") Integer size) {
        Page<UserResponse> findUserAndRole = userService.findUserAndRole(user,role,page, size);
        int offset = findUserAndRole.getNumber() * size;
        boolean last = findUserAndRole.getContent().isEmpty();

        Data<UserResponse> data = Data.<UserResponse>builder()
                .content(findUserAndRole.getContent())
                .pageable(Pageable.builder()
                        .sort(Sort.builder()
                                .empty(Boolean.FALSE)
                                .sorted(Boolean.TRUE)
                                .unsorted(Boolean.FALSE)
                                .build())
                        .offset(offset)
                        .pageSize(findUserAndRole.getSize())
                        .pageNumber(findUserAndRole.getNumber()+1)
                        .paged(Boolean.TRUE)
                        .unpaged(Boolean.FALSE)
                        .build())
                .last(last)
                .totalPages(findUserAndRole.getTotalPages())
                .size(size)
                .number(findUserAndRole.getNumber()+1)
                .first((page+1) == 1)
                .numberOfElements(findUserAndRole.getContent().size())
                .empty(findUserAndRole.getContent().isEmpty())
                .build();

        PaggingAndFilterResponse<UserResponse> paggingAndFilterResponse = PaggingAndFilterResponse.<UserResponse>builder()
                .data(data)
                .message("Succes")
                .status(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(paggingAndFilterResponse);
    }

}