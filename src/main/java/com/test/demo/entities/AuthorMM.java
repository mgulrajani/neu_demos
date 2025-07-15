package com.test.demo.entities;

import com.test.demo.repos.BookRepo;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor

@Getter
@Setter

public class AuthorMM {

    @Override
    public String toString() {
        return "AuthorMM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<BookMM> books = new HashSet<>();

    public void addBooks(BookMM b){

        books.add(b);



    }

    public void removeBooks(BookMM b){
        books.remove(b);


    }

    public AuthorMM(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuthorMM authorMM = (AuthorMM) o;
        return Objects.equals(getId(), authorMM.getId()) && Objects.equals(getName(), authorMM.getName()) && Objects.equals(getBooks(), authorMM.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBooks());
    }
}
