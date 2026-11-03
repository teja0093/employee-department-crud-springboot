package com.SpringCRUD2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.SpringCRUD2.entities.employee;
import com.SpringCRUD2.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService es;

    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

    @PostMapping("/add")
    public String add(@RequestBody employee e) {
        return es.addEmployee(e);
    }

    @GetMapping("/all")
    public List<employee> getAll() {
        return es.getEmployees();
    }

    @GetMapping("/{id}")
    public employee getOne(@PathVariable int id) {
        return es.getEmployeeById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody employee e) {
        return es.updateEmployee(e);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return es.deleteEmployee(id);
    }
}