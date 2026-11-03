package com.SpringCRUD2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.SpringCRUD2.entities.employee;
import com.SpringCRUD2.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository er;

    public EmployeeServiceImpl(EmployeeRepository er) {
        this.er = er;
    }

    @Override
    public String addEmployee(employee e) {
        er.save(e);
        return "Employee added";
    }

    @Override
    public String updateEmployee(employee e) {
        if (!er.existsById(e.getEid())) {
            return "Employee not found";
        }
        er.save(e);
        return "Employee updated";
    }

    @Override
    public String deleteEmployee(int id) {
        if (!er.existsById(id)) {
            return "Employee not found";
        }
        er.deleteById(id);
        return "Employee deleted";
    }

    @Override
    public List<employee> getEmployees() {
        return er.findAll();
    }

    @Override
    public employee getEmployeeById(int id) {
        return er.findById(id).orElse(null);
    }
}