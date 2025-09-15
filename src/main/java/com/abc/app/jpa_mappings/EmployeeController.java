package com.abc.app.jpa_mappings;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AadharRepository aadharRepository;

    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }

    // best practice using DTO
    @PostMapping("/dto")
    public Employee addNewEmployeeByDto(@RequestBody EmployeeDto employeeDto) {

        // created Employee transient object and persisted it
        return this.employeeRepository
                .save(new Employee(employeeDto.getName(), employeeDto.getSalary()));
    }

    // Using AadharDto post to existing Employee

    @PostMapping("/dto/aadhar/{employeeId}")
    public Aadhar addNewAadhar(@RequestBody AadharDto aadharDto, @PathVariable("employeeId") Integer id) throws Exception {
        Aadhar newAadhar = this.aadharRepository.save(new Aadhar(aadharDto.getAadharNo()));
        Employee founEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new Exception("Employee id does not exists"));
        founEmployee.setAadhar(newAadhar);
        this.employeeRepository.save(founEmployee);
        return newAadhar;
    }


    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer employeeId) throws Exception {
        return this.employeeRepository.findById(employeeId).
                orElseThrow(() -> new Exception("Employee id does not exists"));
    }

    @GetMapping("/aadhar/{aadharId}")
    public Employee getAadharById(@PathVariable("aadharId") Integer aadharId) throws Exception {
        // check if employee is fetched along with aadhar

        Aadhar founAadhar = this.aadharRepository.findById(aadharId).
                orElseThrow(() -> new Exception("Employee id does not exists"));

        Employee employee = founAadhar.getEmployee();
        return employee;
    }
}
