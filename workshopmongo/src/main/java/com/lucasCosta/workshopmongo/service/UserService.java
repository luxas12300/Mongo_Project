package com.lucasCosta.workshopmongo.service;

import com.lucasCosta.workshopmongo.domain.User;
import com.lucasCosta.workshopmongo.dto.UserDTO;
import com.lucasCosta.workshopmongo.service.exception.ObjectNotFoundException;
import com.lucasCosta.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User insert (User obj){
        return userRepository.insert(obj);
    }

    public void delete(String id){
        userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
        userRepository.deleteById(id);
    }

    public User update(User obj){
        User newObj = userRepository.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        updateData(obj, newObj);
        return userRepository.save(newObj);
    }

    private void updateData(User obj, User newObj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
