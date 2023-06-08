package com.example.springboot_file_upload_download.service;

import com.example.springboot_file_upload_download.model.Employee;
import com.example.springboot_file_upload_download.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    public Employee createEmployee(Employee emp){
        return empRepo.save(emp);
    }

    public List<Employee> getAllEmployee(){
        List<Employee> empList = empRepo.findAll();
        return empList;
    }

    public Optional<Employee> getEmployeeById(long id){
        return empRepo.findById(id);
    }
}
