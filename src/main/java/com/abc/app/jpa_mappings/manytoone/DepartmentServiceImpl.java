package com.abc.app.jpa_mappings.manytoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
//    @Transactional
    public String getDepartmentById(Integer id) throws Exception {
        // hibernate session starts
        Department department =
                this.departmentRepo.findById(id)
                        .orElseThrow(() -> new Exception("Dept not found"));

        department.getProjects().size();// explictly accessing projects
        return department.getName();
        //hibernate session ends
    }
}
