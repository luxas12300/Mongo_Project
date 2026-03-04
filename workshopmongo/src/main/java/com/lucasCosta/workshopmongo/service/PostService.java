package com.lucasCosta.workshopmongo.service;

import com.lucasCosta.workshopmongo.domain.Post;
import com.lucasCosta.workshopmongo.domain.User;
import com.lucasCosta.workshopmongo.dto.UserDTO;
import com.lucasCosta.workshopmongo.repository.PostRepository;
import com.lucasCosta.workshopmongo.repository.UserRepository;
import com.lucasCosta.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }


}
