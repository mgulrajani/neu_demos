package com.test.demo.services;

import com.test.demo.entities.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    public Author addAuthor(Author author);

    public Author getAuthorById(Long id);

    public Author updateAuthor(Long id, Author author);

    public void deleteAuthor(Long id);
}

