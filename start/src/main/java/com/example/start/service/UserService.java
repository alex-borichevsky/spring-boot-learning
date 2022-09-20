package com.example.start.service;

import com.example.start.entity.UserEntity;
import com.example.start.model.User;
import com.example.start.exception.UserAlreadyExist;
import com.example.start.exception.UserNotFoundException;
import com.example.start.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExist("Пользователь с таким именем существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }

}
