package com.SpringCRUD2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.SpringCRUD2.entities.department;
import com.SpringCRUD2.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    private final DepartmentService ds;

    public DepartmentController(DepartmentService ds) {
        this.ds = ds;
    }

    @PostMapping("/add")
    public String add(@RequestBody department d) {
        return ds.addDepartment(d);
    }

    @GetMapping("/all")
    public List<department> getAll() {
        return ds.getDepartments();
    }

    @GetMapping("/{id}")
    public department getOne(@PathVariable int id) {
        return ds.getDepartmentById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody department d) {
        return ds.updateDepartment(d);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return ds.deleteDepartment(id);
    }
}