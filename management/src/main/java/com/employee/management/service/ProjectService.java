package com.employee.management.service;


import com.employee.management.model.Project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.data.ProjectData;


@Service
public class ProjectService {

	@Autowired
	private ProjectData projectdata;
	
	// fetching all projects
		public List<Project> getAllProject(){
			List<Project> proj = (List<Project>)projectdata.findAll(); 
			return proj;
		}
		
		// fetching project by id
		public Optional<Project> getProject(int id){
			return projectdata.findById(id);
		}
		
		// inserting project
		public void addProject(Project p) {
			projectdata.save(p);
		}
		
		// updating project by id
		public void updateProject(Project p, int id){
			if(id == p.getProject_ID()) {
				projectdata.save(p);
			}
		}
		
		// deleting all projects
		public void deleteAllProject(){
			projectdata.deleteAll();
		}
		
		// deleting projects by id
		public void deleteProjectByID(int id){
			projectdata.deleteById(id);
		}
		
		//patching/updating project by id
		public void patchProject(Project p, int id) {
			if(id == p.getProject_ID()) {
				projectdata.save(p);
			}
		}
}
