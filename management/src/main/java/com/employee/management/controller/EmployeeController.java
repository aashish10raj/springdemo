package com.employee.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	// displaying list of all employees
		@GetMapping("/employees")
		public List<Employee> getAllEmployee(){
			return employeeservice.getAllEmployees();
		}

		// displaying employee by id
		@GetMapping("/employees/{id}")
		public Optional<Employee> getEmployee(@PathVariable int id){
			return employeeservice.getEmployee(id);
		}
		
		// inserting employee
		@PostMapping("/employees")
		public void addEmployees(@RequestBody Employee employee){
			employeeservice.addEmployee(employee);
		}

		//updating employee by id
		@PutMapping("/employees/{id}")
		public void updateEmployee(@RequestBody Employee e, @PathVariable int id){
			employeeservice.updateEmployee(e, id);
		}
		
		// deleting all employees
		@DeleteMapping("/employees")
		public void deleteAllEmployees(){
			employeeservice.deleteAllEmployees();
		}

		// deleting employee by id
		@DeleteMapping("employees/{id}")
		public void deleteEmployeeByID(@RequestBody Employee e, @PathVariable int id){
			employeeservice.deleteEmployeeByID(id);
		}

		// updating/ patching employee by id
		@PatchMapping("employees/{id}")
		public void patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
			employeeservice.patchEmployee(e, id);
		}
}
