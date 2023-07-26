package com.sci.spring23.controllers;

import com.sci.spring23.dto.request.EmployeeRequest;
import com.sci.spring23.dto.response.EmployeeResponse;
import com.sci.spring23.models.Employee;
import com.sci.spring23.services.EmployeeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<?> getAllEmployees() {
    List<Employee> employeeList = employeeService.getAll();
    return new ResponseEntity<>(employeeList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getEmployeeById(@PathVariable long id) {
    Employee employee = employeeService.getById(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
    Employee employee = employeeService.create(employeeRequest);
    return new ResponseEntity<>(employee, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> editEmployee(@PathVariable long id,
      @RequestBody EmployeeRequest employeeRequest) {
    Employee employee = employeeService.edit(id, employeeRequest);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
    employeeService.delete(id);
    return new ResponseEntity<>("Deleted successfully", HttpStatus.NO_CONTENT);
  }
}