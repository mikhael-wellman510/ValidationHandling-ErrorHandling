package com.example.ErrorHandling.Repositori;

import com.example.ErrorHandling.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {


}
