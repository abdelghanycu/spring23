package com.sci.spring23.controllers;

import com.sci.spring23.dto.request.EmployeeRequest;
import com.sci.spring23.dto.response.EmployeeResponse;
import com.sci.spring23.services.EmployeeService;
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

  @PostMapping
  public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest request) {
    log.error("hi i'm {} here", request);
    EmployeeResponse response = employeeService.createEmployee(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<?> getEmployee() {
    return new ResponseEntity<>("Hi Mustafa", HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getEmployeeById(@PathVariable int id) {
    return new ResponseEntity<>("Hi " + id, HttpStatus.OK);
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<?> getEmployeeByName(@PathVariable String name) {
    return new ResponseEntity<>("Hi " + name, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> updateEmployeeByName() {
    return new ResponseEntity<>("Hi update", HttpStatus.OK);
  }

  @DeleteMapping
  public ResponseEntity<?> deleteEmployeeByName() {
    return new ResponseEntity<>("Hi delete", HttpStatus.OK);
  }
}
