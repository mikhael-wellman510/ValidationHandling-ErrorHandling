package com.example.ErrorHandling.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class RoleRequest {
    private String id;
    @NotBlank
    private String roleName;
    @NotBlank
    private String description;
}
