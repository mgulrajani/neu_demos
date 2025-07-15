package com.test.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


@Getter
@Setter

public class BookMM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;


    @ManyToMany
    @JoinTable(name = "book_author",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<AuthorMM> authors = new HashSet<>();



public void addAuthor(AuthorMM a) {
    authors.add(a);
}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookMM bookMM = (BookMM) o;
        return Objects.equals(getId(), bookMM.getId()) && Objects.equals(getTitle(), bookMM.getTitle()) && Objects.equals(getAuthors(), bookMM.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getAuthors());
    }

    public void removeAuthor(AuthorMM a){
    authors.remove(a);

}

    @Override
    public String toString() {
        return "BookMM{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}