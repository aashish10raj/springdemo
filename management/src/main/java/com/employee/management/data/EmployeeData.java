package com.employee.management.data;



import org.springframework.data.repository.CrudRepository;

import com.employee.management.model.Employee;

public interface EmployeeData extends CrudRepository<Employee, Integer> {

}
