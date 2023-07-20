package com.sci.spring23.services;

import com.sci.spring23.dto.request.EmployeeRequest;
import com.sci.spring23.dto.response.EmployeeAttributeResponse;
import com.sci.spring23.dto.response.EmployeeResponse;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  public EmployeeResponse createEmployee(EmployeeRequest request) {
    return new EmployeeResponse(15 + (int) Math.random() * 100,
        new EmployeeAttributeResponse(request.getName(), request.getAddress(), request.getAge(),
            request.getCountry()));
  }
}
