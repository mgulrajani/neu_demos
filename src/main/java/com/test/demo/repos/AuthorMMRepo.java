package com.test.demo.repos;

import com.test.demo.entities.AuthorMM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorMMRepo  extends JpaRepository<AuthorMM ,Long> {
}
