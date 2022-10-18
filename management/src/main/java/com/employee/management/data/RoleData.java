package com.employee.management.data;

import org.springframework.data.repository.CrudRepository;


import com.employee.management.model.Role;
public interface RoleData extends CrudRepository<Role, Integer> {

}
