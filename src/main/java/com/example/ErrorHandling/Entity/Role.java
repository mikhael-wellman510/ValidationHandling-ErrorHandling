package com.example.ErrorHandling.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_role")
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "role_name" , nullable = false)
    private String roleName;

    @Column(nullable = false)
    private String description;


}
