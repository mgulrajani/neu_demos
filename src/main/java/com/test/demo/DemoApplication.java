package com.test.demo;

import com.test.demo.dtos.AuthorDTO;
import com.test.demo.dtos.BookDTO;
import com.test.demo.entities.*;
import com.test.demo.repos.AuthorMMRepo;
import com.test.demo.repos.AuthorRepo;
import com.test.demo.repos.BookMMRepo;
import com.test.demo.repos.BookRepo;
import com.test.demo.services.EmployeeService;
import com.test.demo.services.ProjectService;
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

 //createing ProjectService object
		ProjectService projectService = context.getBean(ProjectService.class);

		Employee e = new Employee("Kajal","Marketing",45000D);
		Employee e1= new Employee("kk","ss",45000D);
		Employee e2= new Employee("d","ggg",45000D);
		Employee e3= new Employee("nn","dd",45000D);

		Employee savedEmployee = service.addEmployee(e);
		Employee savedEmployee1 = service.addEmployee(e1);
		Employee savedEmployee2 = service.addEmployee(e2);
		Employee savedEmployee3 = service.addEmployee(e3);


		//creating a project and assigning employees to it
		Set<Employee> employees = new HashSet<>();
		employees.add(savedEmployee);
		employees.add(savedEmployee1);
		employees.add(savedEmployee2);
		employees.add(savedEmployee3);
		Project project = new Project("Portfolio Management", LocalDate.now());
		project.setEmployees(employees);
		Project savedProject = projectService.addProject(project);
		System.out.println("Saved Project: " + savedProject);

		//creating a project and assigning employees to it

		Project project2 = new Project("Inventory Management", LocalDate.now());
		project2.setEmployees(Set.of(savedEmployee, savedEmployee3));

		Project savedProject2 = projectService.addProject(project2);
		System.out.println("Saved Project 2: " + savedProject2);

		List<Employee> ee = service.listAllEmployees();
		System.out.println(ee);
		Employee eeByName = service.findEmployeeById(savedEmployee.getId());
		System.out.println(eeByName);
		Employee updatedEmployee = service.updateEmployee(savedEmployee.getId(), new Employee("Updated Name", "Updated Dept", 50000D));
		System.out.println("Updated Employee: " + updatedEmployee);
		System.out.println("All Employees after update:");

		System.out.println("List of projects for employee with ID " + savedEmployee.getId() + ":");
		List<Project> projects = projectService.findProjectsByEmployeeId(savedEmployee3.getId());
		for (Project p : projects) {
			System.out.println(p);
		}

		Employee mm= new Employee("Jim","Sales",50000D);
		Employee jdbcdee =  service.addEmployeejdbc(mm);
		System.out.println("Added Employee using JDBCmain " + jdbcdee);


		//invoke projectservice method to get employee count per project
		System.out.println("Employee count per project:");
		projectService.getEmployeeCountPerProject().forEach((projectName, count) -> {
			System.out.println("Project: " + projectName + ", Employee Count: " + count);
		});


		// Uncomment the following lines to see the output of the Employee and Address objects


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
