package com.lucasCosta.workshopmongo.config;

import com.lucasCosta.workshopmongo.domain.Post;
import com.lucasCosta.workshopmongo.domain.User;
import com.lucasCosta.workshopmongo.dto.AuthorDTO;
import com.lucasCosta.workshopmongo.dto.CommentsDTO;
import com.lucasCosta.workshopmongo.dto.UserDTO;
import com.lucasCosta.workshopmongo.repository.PostRepository;
import com.lucasCosta.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        User maria = new User(null, "Maria João","maria@email");
        User joao = new User(null, "João Maria","joao@email");
        User bob = new User(null, "Bob Jesus","bob@email");

        userRepository.saveAll(Arrays.asList(maria,joao,bob));

        postRepository.deleteAll();
        Post post1 = new Post(null, sdf.parse("21/01/2026"), "Viagem", "Vou pra Espanha", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("22/02/2026"), "Carnaval", "Vou pra rua", new AuthorDTO(joao));

        CommentsDTO c1 = new CommentsDTO(sdf.parse("02/03/2026"),new AuthorDTO(joao),"Boa viagem!");
        CommentsDTO c2 = new CommentsDTO(sdf.parse("01/02/2026"),new AuthorDTO(bob),"Curta muito!");
        CommentsDTO c3 = new CommentsDTO(sdf.parse("05/05/2025"),new AuthorDTO(bob),"Tudo de bom!");

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));

        userRepository.save(maria);

    }
}
