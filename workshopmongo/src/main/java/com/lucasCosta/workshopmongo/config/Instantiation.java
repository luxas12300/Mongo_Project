package com.lucasCosta.workshopmongo.config;

import com.lucasCosta.workshopmongo.domain.User;
import com.lucasCosta.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        User maria = new User(null, "Maria João","maria@email");
        User joao = new User(null, "João Maria","joao@email");
        User bob = new User(null, "Bob Jesus","bob@email");

        repository.saveAll(Arrays.asList(maria,joao,bob));
    }
}
