package com.sci.spring23.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAttributeResponse {

  private String name;
  private String address;
  private int age;
  private String country;
}
