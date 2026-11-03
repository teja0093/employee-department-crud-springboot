package com.SpringCRUD2.service;

import java.util.List;
import com.SpringCRUD2.entities.department;

public interface DepartmentService {
    String addDepartment(department d);
    String updateDepartment(department d);
    String deleteDepartment(int id);
    List<department> getDepartments();
    department getDepartmentById(int id);
}