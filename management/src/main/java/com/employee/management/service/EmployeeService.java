package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.data.EmployeeData;
import com.employee.management.model.Employee;


@Service
public class EmployeeService {

	@Autowired 
	private EmployeeData employeedata;
	
	// fetching all employees
		public List<Employee> getAllEmployees(){
			List<Employee> emps = (List<Employee>)employeedata.findAll(); 
			return emps;
		}
		
		// fetching employee by id
		public Optional<Employee> getEmployee(int id){
			return employeedata.findById(id);
		}
		
		// inserting employee
		public void addEmployee(Employee e) {
			employeedata.save(e);
		}
		
		// updating employee by id
		public void updateEmployee(Employee emp, int id){
			if(id == emp.getEmployeeId()) {
				employeedata.save(emp);
			}
		}
		
		// deleting all employees
		public void deleteAllEmployees(){
			employeedata.deleteAll();
		}
		
		// deleting employee by id
		public void deleteEmployeeByID(int id){
			employeedata.deleteById(id);
		}
		
		//patching/updating employee by id
		public void patchEmployee(Employee emp, int id) {
			if(id == emp.getEmployeeId()) {
				employeedata.save(emp);
			}
		}
	
}
