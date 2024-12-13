package com.example.ErrorHandling.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RoleResponse {
    private String id;
    private String roleName;
    private String description;
}
