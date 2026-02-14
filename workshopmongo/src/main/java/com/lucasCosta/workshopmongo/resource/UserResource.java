package com.lucasCosta.workshopmongo.resource;

import com.lucasCosta.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User lucas = new User("1","Lucas","lucas@email");
        User carol = new User("2","Carol","carol@email");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(lucas,carol));
        return ResponseEntity.ok().body(list);
    }
}
