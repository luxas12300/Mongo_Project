package com.lucasCosta.workshopmongo.service;

import com.lucasCosta.workshopmongo.domain.User;
import com.lucasCosta.workshopmongo.service.exception.ObjectNotFoundException;
import com.lucasCosta.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
         return userRepository.findById(id)
                 .orElseThrow(() -> new ObjectNotFoundException("User not found"));

    }
}
