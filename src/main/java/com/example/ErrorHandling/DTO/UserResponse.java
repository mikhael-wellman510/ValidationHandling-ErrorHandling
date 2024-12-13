package com.example.ErrorHandling.DTO;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class UserResponse {
    private String id;
    private String name;
    private String hobby;
    private Integer age;
    private String address;
    private String email;
    private String phoneNumber;
    private RoleResponse roleResponse;
}
