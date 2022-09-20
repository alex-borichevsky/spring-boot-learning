package com.example.start.repository;

import com.example.start.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
   UserEntity findByUsername(String username);
}
