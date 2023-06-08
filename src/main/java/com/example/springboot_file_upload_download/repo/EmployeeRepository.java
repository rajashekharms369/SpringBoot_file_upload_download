package com.example.springboot_file_upload_download.repo;

import com.example.springboot_file_upload_download.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
