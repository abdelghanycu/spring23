package com.sci.spring23.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  @Id
  @GeneratedValue(generator = "employee_generator")
  @SequenceGenerator(
      name = "employee_generator",
      sequenceName = "employee_sequence",
      initialValue = 1
  )
  private long id;
  private String name;
  private String address;
  private int age;
  private String country;
}
