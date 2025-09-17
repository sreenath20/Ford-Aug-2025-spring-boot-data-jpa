package com.abc.app.jpa_mappings.manytoone;

import com.abc.app.jpa_mappings.Employee;
import com.abc.app.jpa_mappings.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private EmployeeRepository employeeRepo;

    // API to add existing employee to existing project
    @PostMapping("/{prj_id}/employee/{emp_id}")
    public Project addEmployeeToProject(@PathVariable Integer prj_id, @PathVariable Integer emp_id) throws Exception {

        Project foundProject = this.projectRepo.findById(prj_id).orElseThrow(() -> new Exception("Project not found for id:" + prj_id));
        Employee foundEmployee = this.employeeRepo.findById(emp_id).orElseThrow(() -> new Exception("Employye not found for id:" + prj_id));
        foundProject.getEmployees().add(foundEmployee);// binding
        return this.projectRepo.save(foundProject);
    }

    @GetMapping("/{prj_id}/employees")
    public List<Employee> getAllEmployeesByProjectId(@PathVariable Integer prj_id) throws Exception {
        Project foundProject = this.projectRepo.findById(prj_id).orElseThrow(() -> new Exception("Project not found for id:" + prj_id));
        return foundProject.getEmployees();

    }
}
