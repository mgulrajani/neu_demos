package com.test.demo;

import com.test.demo.dtos.AuthorDTO;
import com.test.demo.dtos.BookDTO;
import com.test.demo.entities.Author;
import com.test.demo.entities.AuthorMM;
import com.test.demo.entities.Book;
import com.test.demo.entities.BookMM;
import com.test.demo.repos.AuthorMMRepo;
import com.test.demo.repos.AuthorRepo;
import com.test.demo.repos.BookMMRepo;
import com.test.demo.repos.BookRepo;
import com.test.demo.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


		EmployeeService service = context.getBean(EmployeeService.class);

		System.out.println(service.listAllEmployees());


/*


		//I have delete the @Configuration and Bean
		//I have annotated the Employee as Component
		//
		Employee gotEmpBean = context.getBean(Employee.class);


		gotEmpBean.setName("Raj");
		gotEmpBean.getAddress().setStreet("mgm");

		System.out.println(gotEmpBean);
		System.out.println(gotEmpBean.getAddress());


		EntityManager em = context.getBean(EntityManager.class);

		Query query = em.createQuery("select e from Employee e");

		List<Employee> elist = query.getResultList();

		for(Employee e:elist){

			System.out.println(e);
		}

      EmployeeRepo repo = context.getBean(EmployeeRepo.class);

		Employee e = new Employee("Kajal","Marketing",45000D);
		Employee e1= new Employee("kk","ss",45000D);
		Employee e2= new Employee("d","ggg",45000D);
		Employee e3= new Employee("nn","dd",45000D);

		Employee savedEmployee = repo.save(e);
		Employee savedEmployee1 = repo.save(e1);
		Employee savedEmployee2 = repo.save(e2);
		Employee savedEmployee3 = repo.save(e3);



		System.out.println(savedEmployee);


		List<Employee> ee = repo.findByName("Jim");
		System.out.println(ee);


		List<Employee> lst = repo.findByDept("Sales");
		System.out.println(lst);


		Set<Employee>  set1  = new HashSet<>();
		set1.add(e);
        set1.add(e1);

		set1.add(e2);
		set1.add(e3);

		Project p1 = new Project("Portfolio Management", LocalDate.now());
		p1.setEmployees(set1);


		ProjectRepo repo2 = context.getBean(ProjectRepo.class);
		Project savedProject = repo2.save(p1);


		System.out.println(savedProject);
		System.out.println(savedProject.getEmployees());




*/
	}
	}
	/*public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	// This is a demo application that uses JPA to manage entities and repositories.
	// It creates an author, adds books to the author, and demonstrates the use of many-to-many relationships.

	@Bean
	public CommandLineRunner demo(AuthorRepo authrepo, BookRepo bkrepo, AuthorMMRepo authrepoMM, BookMMRepo bookrepoMM){

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

		bookrepoMM.saveAll(List.of(bMM,bMM2));


		System.out.println("saved books  and now retrieving them ");
	    BookMM retrievedBook = bookrepoMM.findById(bMM.getId()).orElseThrow();
		System.out.println("first book "+ retrievedBook);

		BookMM retrievedBook2 =  bookrepoMM.findById(bMM2.getId()).orElseThrow();
		System.out.println(retrievedBook2);

		System.out.println("now adding them ");
		rishimm.addBooks(retrievedBook);

        rishimm.setBooks(Set.of(retrievedBook,retrievedBook2));
		System.out.println("added books to authorMM "+rishimm.getBooks());

		        // Fetch authors and map to DTOs
		        List<AuthorDTO> authorDTOs = authrepoMM.findAll().stream().map(author ->
		            new AuthorDTO(
		                author.getId(),
		                author.getName(),
		                author.getBooks().stream()
		                    .map(book -> new BookDTO(book.getId(), book.getTitle()))
		                    .toList()
		            )
		        ).toList();

		        // Print DTOs
		        authorDTOs.forEach(dto -> {
		            System.out.println("AuthorDTO: " + dto.getName() + ", Books: " + dto.getBooks().stream().map(BookDTO::getTitle).toList());
		        });

		        // ... existing code



		authrepoMM.save(rishimm);

		System.out.println("reached  rishim");
	};
	}
}
*/
