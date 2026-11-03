package com.SpringCRUD2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.SpringCRUD2.entities.department;
import com.SpringCRUD2.entities.employee;
import com.SpringCRUD2.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository dr;

    public DepartmentServiceImpl(DepartmentRepository dr) {
        this.dr = dr;
    }

    @Override
    public String addDepartment(department d) {
        // link every employee to this department so the foreign key is saved
        if (d.getEmployees() != null) {
            for (employee e : d.getEmployees()) {
                e.setDepartment(d);
            }
        }
        dr.save(d);
        return "Department added";
    }

    @Override
    public String updateDepartment(department d) {
        if (!dr.existsById(d.getDeptId())) {
            return "Department not found";
        }
        if (d.getEmployees() != null) {
            for (employee e : d.getEmployees()) {
                e.setDepartment(d);
            }
        }
        dr.save(d);
        return "Department updated";
    }

    @Override
    public String deleteDepartment(int id) {
        if (!dr.existsById(id)) {
            return "Department not found";
        }
        dr.deleteById(id);   // also deletes its employees (cascade ALL)
        return "Department deleted";
    }

    @Override
    public List<department> getDepartments() {
        return dr.findAll();
    }

    @Override
    public department getDepartmentById(int id) {
        return dr.findById(id).orElse(null);
    }
}