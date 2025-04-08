package com.Rcmpdi.EMP_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Rcmpdi.EMP_manager.entity.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
