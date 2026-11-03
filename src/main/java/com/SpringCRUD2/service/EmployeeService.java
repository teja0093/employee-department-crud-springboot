package com.SpringCRUD2.service;

import java.util.List;
import com.SpringCRUD2.entities.employee;

public interface EmployeeService {
    String addEmployee(employee e);
    String updateEmployee(employee e);
    String deleteEmployee(int id);
    List<employee> getEmployees();
    employee getEmployeeById(int id);
}