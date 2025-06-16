package com.dxers.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxers.web.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    boolean existsByUserEmail(String userEmail);

    UserEntity findByUserEmail(String userEmail);

}
