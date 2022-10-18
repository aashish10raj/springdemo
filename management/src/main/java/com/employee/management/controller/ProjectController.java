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


import com.employee.management.model.Project;
import com.employee.management.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectservice;
	
	// displaying list of all projects
			@GetMapping("/project")
			public List<Project> getAllProject(){
				return projectservice.getAllProject();
			}

			// displaying Project by id
			@GetMapping("/project/{id}")
			public Optional<Project> getProject(@PathVariable int id){
				return projectservice.getProject(id);
			}
			
			// inserting project
			@PostMapping("/project")
			public void addProject(@RequestBody Project project){
				projectservice.addProject(project);
			}

			//updating project by id
			@PutMapping("/project/{id}")
			public void updateProject(@RequestBody Project p, @PathVariable int id){
				projectservice.updateProject(p, id);
			}
			
			// deleting all project
			@DeleteMapping("/project")
			public void deleteAllProject(){
				projectservice.deleteAllProject();
			}

			// deleting project by id
			@DeleteMapping("project/{id}")
			public void deleteProjectByID(@RequestBody Project p, @PathVariable int id){
				projectservice.deleteProjectByID(id);
			}

			// updating/ patching project by id
			@PatchMapping("project/{id}")
			public void patchProjectByID(@RequestBody Project p, @PathVariable int id) {
				projectservice.patchProject(p, id);
			}

}
