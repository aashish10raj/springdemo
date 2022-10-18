package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.data.RoleData;
import com.employee.management.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleData roledata;
	
	// fetching all roles
			public List<Role> getAllRole(){
				List<Role> role = (List<Role>)roledata.findAll(); 
				return role;
			}
			
			// fetching roles by id
			public Optional<Role> getRole(int id){
				return roledata.findById(id);
			}
			
			// inserting role
			public void addRole(Role r) {
				roledata.save(r);
			}
			
			// updating role by id
			public void updateRole(Role r, int id){
				if(id == r.getRole_ID()) {
					roledata.save(r);
				}
			}
			
			// deleting all role
			public void deleteAllRole(){
				roledata.deleteAll();
			}
			
			// deleting role by id
			public void deleteRoleByID(int id){
				roledata.deleteById(id);
			}
			
			//patching/updating role by id
			public void patchRole(Role r, int id) {
				if(id == r.getRole_ID()) {
					roledata.save(r);
				}
			}
}
