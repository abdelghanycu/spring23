package com.sci.spring23.services;

import com.sci.spring23.dto.request.EmployeeRequest;
import com.sci.spring23.dto.response.EmployeeAttributeResponse;
import com.sci.spring23.dto.response.EmployeeResponse;
import com.sci.spring23.models.Employee;
import com.sci.spring23.repo.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> getAll() {
    return employeeRepository.findAll();
  }

  public Employee create(EmployeeRequest employeeRequest) {
    Employee employee = new Employee();
    employee.setName(employeeRequest.getName());
    employee.setAddress(employeeRequest.getAddress());
    employee.setAge(employeeRequest.getAge());
    employee.setCountry(employeeRequest.getCountry());
    employeeRepository.save(employee);
    return employee;
  }

  public Employee getById(long id) {
    return employeeRepository.findById(id).get();
  }

  public Employee edit(long id, EmployeeRequest employeeRequest) {
    Employee employee = employeeRepository.findById(id).get();
    employee.setName(employeeRequest.getName());
    employee.setAddress(employeeRequest.getAddress());
    employee.setAge(employeeRequest.getAge());
    employee.setCountry(employeeRequest.getCountry());
    employeeRepository.save(employee);
    return employee;
  }

  public void delete(long id) {
    employeeRepository.deleteById(id);
  }
}
