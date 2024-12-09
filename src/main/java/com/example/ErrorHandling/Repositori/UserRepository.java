package com.example.ErrorHandling.Repositori;

import com.example.ErrorHandling.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , String> {

}
