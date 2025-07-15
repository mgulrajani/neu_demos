package com.test.demo;

import com.test.demo.entities.Author;
import com.test.demo.entities.AuthorMM;
import com.test.demo.entities.Book;
import com.test.demo.entities.BookMM;
import com.test.demo.repos.AuthorMMRepo;
import com.test.demo.repos.AuthorRepo;
import com.test.demo.repos.BookMMRepo;
import com.test.demo.repos.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(AuthorRepo authrepo, BookRepo bkrepo, AuthorMMRepo mmrepo1, BookMMRepo mmrepo2){

	return  args -> {


		System.out.println("creating author"+"******************1");
		Author rishi = new Author("rishi");

		System.out.println("created  author"+"******************2");

		rishi.addBook(new Book("tao of physics", LocalDate.now(),33434));
		System.out.println("added book "+"*************  3");
		authrepo.save(rishi);
		authrepo.findAll().forEach(a-> System.out.println("author"+a.getName()));

		AuthorMM  rishimm = new AuthorMM("rishiMM");

		BookMM bMM = new BookMM();
		bMM.setTitle("ramayan");

		BookMM bMM2= new BookMM();
		bMM2.setTitle("Kaliyug");

		mmrepo2.saveAll(List.of(bMM,bMM2));


		System.out.println("saved books  and now retrieving them ");
	    BookMM retrievedBook = mmrepo2.findById(bMM.getId()).orElseThrow();
		System.out.println("first book "+ retrievedBook);

		BookMM retrievedBook2 =  mmrepo2.findById(bMM2.getId()).orElseThrow();
		System.out.println(retrievedBook2);

		System.out.println("now adding them ");
		rishimm.addBooks(retrievedBook);

        rishimm.setBooks(Set.of(retrievedBook,retrievedBook2));

		mmrepo1.save(rishimm);

		System.out.println("reached  rishim");
	};
	}
}
