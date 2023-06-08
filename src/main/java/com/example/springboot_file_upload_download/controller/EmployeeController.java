package com.example.springboot_file_upload_download.controller;

import com.example.springboot_file_upload_download.model.Employee;
import com.example.springboot_file_upload_download.service.EmployeeService;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeService empService;

    @GetMapping("/")
    public String home(Model model){
        List<Employee> list = empService.getAllEmployee();
        model.addAttribute("list", list);
        return "index";
    }

    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        Employee emp = new Employee();
        String filename = file.getOriginalFilename();
        emp.setProfilePicture(filename);
        emp.setContent(file.getBytes());
        emp.setSize(file.getSize());
        empService.createEmployee(emp);
        model.addAttribute("success", "file Uploaded Successfully");
        return "index";
    }

    @GetMapping("/download")
    public void downloadFile(@Param("id") Long id, Model model, HttpServletResponse response) throws IOException {
        Optional<Employee> temp = empService.getEmployeeById(id);
        if(temp.isPresent()){
            Employee emp = temp.get();
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment filename: "+emp.getProfilePicture();
            response.setHeader(headerKey, headerValue);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(emp.getContent());
            outputStream.close();

        }
    }

    @GetMapping("/image")
    public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<Employee> employee) throws IOException {
        employee = empService.getEmployeeById(id);
        response.setContentType("image/jpeg");
        if(employee.isPresent()){
            response.getOutputStream().write(employee.get().getContent());
        }
        response.getOutputStream().close();
    }
}
