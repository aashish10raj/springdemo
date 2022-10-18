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


import com.employee.management.model.Role;
import com.employee.management.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleservice;
	
	// displaying list of all role
				@GetMapping("/role")
				public List<Role> getAllRole(){
					return roleservice.getAllRole();
				}

				// displaying role by id
				@GetMapping("/role/{id}")
				public Optional<Role> getRole(@PathVariable int id){
					return roleservice.getRole(id);
				}
				
				// inserting role
				@PostMapping("/role")
				public void addRole(@RequestBody Role role){
					roleservice.addRole(role);
				}

				//updating role by id
				@PutMapping("/role/{id}")
				public void updateRole(@RequestBody Role r, @PathVariable int id){
					roleservice.updateRole(r, id);
				}
				
				// deleting all role
				@DeleteMapping("/role")
				public void deleteAllRole(){
					roleservice.deleteAllRole();
				}

				// deleting role by id
				@DeleteMapping("role/{id}")
				public void deleteRoleByID(@RequestBody Role r, @PathVariable int id){
					roleservice.deleteRoleByID(id);
				}

				// updating/ patching role by id
				@PatchMapping("role/{id}")
				public void patchRoleByID(@RequestBody Role r, @PathVariable int id) {
					roleservice.patchRole(r, id);
				}

	
}
