package com.sci.spring23.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

  private int id;
  private EmployeeAttributeResponse attribute;
}
