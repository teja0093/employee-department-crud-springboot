package com.SpringCRUD2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.SpringCRUD2.entities.employee;

@Repository
public interface EmployeeRepository extends JpaRepository<employee, Integer> {
}