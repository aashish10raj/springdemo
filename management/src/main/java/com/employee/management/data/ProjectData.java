package com.employee.management.data;

import org.springframework.data.repository.CrudRepository;


import com.employee.management.model.Project;


public interface ProjectData extends CrudRepository<Project, Integer>{

}
