package com.abc.app;

import com.abc.app.jpa_mappings.Employee;
import com.abc.app.jpa_mappings.EmployeeRepository;
import com.abc.app.jpa_mappings.manytoone.Project;
import com.abc.app.jpa_mappings.manytoone.ProjectRepo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "My Awesome API",
                version = "1.0",
                description = "This is a comprehensive API for managing various resources."
        )
)
public class ProductappApplication implements CommandLineRunner {

    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private EmployeeRepository employeeRepo;

    public static void main(String[] args) {
        SpringApplication.run(ProductappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("*** Satrting CommandLineRunner run method ***");
        // Create entity objects = trancient object
        Project newProject = new Project(null,"Demo project 02",750000.0,null);

        Employee newEmployee1 = new Employee("Demo emp 01", 1000.0); // new entity object

        Employee newEmployee2 = new Employee("Demo emp 02", 2000.0);
       // newEmployee1 = this.employeeRepo.save(newEmployee1); // persisted/ saved object
        System.out.println("Emp 1: "+ newEmployee1);
       // newEmployee2 = this.employeeRepo.save(newEmployee2);//

        newProject.getEmployees().add(newEmployee1);
        newProject.getEmployees().add(newEmployee2);
        newEmployee1 = this.employeeRepo.findById(1652).orElseThrow();
        newEmployee2 = this.employeeRepo.findById(1653).orElseThrow();

        Project newProject2 = new Project(null,"Demo project 03",850000.0,null);
        newProject2.getEmployees().add(newEmployee1);

//        newProject2 = this.projectRepo.save(newProject2);
//        newProject = projectRepo.save(newProject);
        // refresh
        newEmployee1 = this.employeeRepo.findById(1652).orElseThrow();
        newEmployee2 = this.employeeRepo.findById(1653).orElseThrow();

        newProject = this.projectRepo.findById(3252).orElseThrow();
        System.out.println("Project 1 : " + newProject);
        System.out.println("Project 1 employees :" + newProject.getEmployees());
        System.out.println("****");
        System.out.println("Project 2: " + newProject2);
        System.out.println("Project 2 employees :" + newProject2.getEmployees());
        System.out.println("****");
        System.out.println("Emp 1: "+ newEmployee1);
        System.out.println("emp 1 project:"+newEmployee1.getProjects());
        System.out.println("****");
        System.out.println("emp2 :"+newEmployee2);
        System.out.println("emp 2 project:"+newEmployee2.getProjects());
        System.out.println("*** Ending CommandLineRunner RUN method ***");
    }
}
