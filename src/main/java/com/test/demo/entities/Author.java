package com.test.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private  String name;

    public Author(int id,String name){
        this.id = id;
        this.name = name;

    }

    public Author(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy="author",cascade= CascadeType.ALL,orphanRemoval = true)
    private List<Book> books =new ArrayList<>();

    public void addBook(Book b){
        books.add(b);
        b.setAuthor(this);
    }

    public void removeBook(Book b){

        books.remove(b);
        b.setAuthor(null);

    }
    
}