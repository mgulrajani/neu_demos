package com.test.demo.repos;

import com.test.demo.entities.BookMM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMMRepo extends JpaRepository<BookMM ,Long> {
}
